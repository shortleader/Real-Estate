package com.budong.model.dto;

public class ReplyDTO {
	private int reply_num;
	private int content_num;
	private String reply_content;

	public int getReply_num() {
		return reply_num;
	}

	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}

	public int getcontent_num() {
		return content_num;
	}

	public void setcontent_num(int content_num) {
		this.content_num = content_num;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

}
