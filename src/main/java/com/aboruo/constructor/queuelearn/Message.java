package com.aboruo.constructor.queuelearn;

public class Message {
	private String msgId;
	private String msgInfo;
	public Message(String string, String string2) {
		this.msgId = string;
		this.msgInfo = string2;
	}
	/**
	 * @return the msgId
	 */
	public String getMsgId() {
		return msgId;
	}
	/**
	 * @param msgId the msgId to set
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	/**
	 * @return the msgInfo
	 */
	public String getMsgInfo() {
		return msgInfo;
	}
	/**
	 * @param msgInfo the msgInfo to set
	 */
	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}
	public String toString(){
		return this.msgInfo;
	}
}
