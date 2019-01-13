package com.budong.model.dto;


/**
 * 
 * @author wjddp 
 * id : 채팅 보낸이 id 
 * room : 채팅방 
 * content : 채팅내용
 */
public class ChatDTO {

	private String id; 
	private String room; 
	private String content;

	public ChatDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public ChatDTO(String id, String room, String content) {
		this.id = id;
		this.room = room;
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	} 
	
	
	
}
