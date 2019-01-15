package com.budong.service;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.budong.controller.ChatController;
import com.budong.model.dto.ChatDTO;
import com.budong.model.dto.MemberDTO;
import com.budong.service.interfaces.ChatService;

/**
 * 
 * @author wjddp 사용자 채팅 - 사용자가 방 입장시 웹소켓 세션을 생성한다. - 방을 이동할경우 기존의 웹소켓 세션을 제거하고 ,
 *         새로운 웹소켓 세션을 생성한다.
 * 
 */

public class WebSocketHandler extends TextWebSocketHandler {
	@Autowired
	private ChatService chatService;

	private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
	private boolean closePrevSession = false;
	private static Map<WebSocketSession, String> sessionList = new ConcurrentHashMap<>(); // 웹소켓 세션, id
	private static Map<WebSocketSession, String> roomList = new ConcurrentHashMap<>(); // 웹소켓 세션, 방 이름

	@Override
	public void afterConnectionEstablished(WebSocketSession currentSession) throws Exception {
		logger.info("======================================");
		logger.info("WebSocket 연결 확인  : " + currentSession.toString());

		Map<String, Object> map = currentSession.getAttributes();
		MemberDTO mdto = (MemberDTO) map.get("login");

		Set<WebSocketSession> key = sessionList.keySet();
		Iterator<WebSocketSession> it = key.iterator();
		WebSocketSession prevSession = null;

		String prevRoomName = chatService.getPrevRoom(mdto.getMem_id());
		String currentRoomName = chatService.getMemberRoom(mdto.getMem_id());

		sessionList.put(currentSession, mdto.getMem_id());
		roomList.put(currentSession, currentRoomName); // 현재 웹소켓 세션, 방이름 저장

		while (it.hasNext()) {
			prevSession = it.next();

			String id1 = (String) sessionList.get(prevSession);
			String id2 = (String) sessionList.get(currentSession);

			// 기존에 연결된 HTTP세션과 mem_id 값이 동일한데
			// 서로 다른 웹 소켓 일경우
			// 이전 웹소켓 연결을 종료 시킴
			if (id1.equals(id2) && prevSession != currentSession) {
				closePrevSession = true;
				break;
			}
		}

		if (closePrevSession) {
			closePrevSession = false;
			sessionList.remove(prevSession);
			sendRoomExitMsg(mdto.getMem_id(),prevRoomName);

			roomList.remove(prevSession);
			prevSession.close();
			sendEnterRoomMsg(mdto.getMem_id(), currentRoomName);
		} else {
			sendEnterRoomMsg(mdto.getMem_id(), currentRoomName);
		}

		logger.info("session  : " + currentSession.toString() + ", httpsession : " + sessionList.get(currentSession));

	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		logger.info("======================================");
		logger.info("WebSocket 연결 해제  : " + session.toString());
		logger.info("session 수  : " + sessionList.size());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info("\n WebSocket onMessage : " + message);

		JSONObject jsonObject = new JSONObject(message.getPayload());
		String id = jsonObject.getString("id"); 
		String roomName = jsonObject.getString("roomName"); 
		String content = jsonObject.getString("text"); 
		
		Set<WebSocketSession> key = roomList.keySet();
		Iterator<WebSocketSession> it = key.iterator();

		// 같은 방에 있는 사용자에게 메시지를 전송
		while (it.hasNext()) {
			WebSocketSession s = it.next();
			if (!roomName.equals("") && roomList.get(s).equals(roomName)) { 
				//chatService.saveChat(new ChatDTO(id,roomName,content));
				s.sendMessage(new TextMessage(message.getPayload()));
			}
		}
	}

	public void sendRoomExitMsg(String id, String prevRoom) throws IOException {
		/**
		 * type : 메시지 타입 id : 퇴장할 사람 id roomName : 퇴장할 방 이름
		 */
		JSONObject jsonObject = new JSONObject();
		jsonObject.append("type", "exitMsg");
		jsonObject.append("id", id);
		jsonObject.append("roomName", prevRoom);

		Set<WebSocketSession> key = roomList.keySet();
		Iterator<WebSocketSession> it = key.iterator();

		// 같은방에 있는 사용자에게 퇴장 메시지 전송
		while (it.hasNext()) {
			WebSocketSession session = it.next();
			if (!prevRoom.equals("") && roomList.get(session).equals(prevRoom)) {
				session.sendMessage(new TextMessage(jsonObject.toString()));
			}
		}
	}

	public void sendEnterRoomMsg(String id, String roomName) throws IOException {
		/*
		 * type : 메시지 타입 id : 입장한 사람 id roomName : 방 이름
		 */
		JSONObject jsonObject = new JSONObject();
		jsonObject.append("type", "enterMsg");
		jsonObject.append("id", id);
		jsonObject.append("roomName", roomName);

		// 같은 방 사용자에게 입장 메시지를 보낸다.
		Set<WebSocketSession> key = roomList.keySet();
		Iterator<WebSocketSession> it = key.iterator();

		while (it.hasNext()) {
			WebSocketSession session = it.next();
			if (!roomName.equals("") && roomList.get(session).equals(roomName)) {
				session.sendMessage(new TextMessage(jsonObject.toString()));
			}
		}
	}
}