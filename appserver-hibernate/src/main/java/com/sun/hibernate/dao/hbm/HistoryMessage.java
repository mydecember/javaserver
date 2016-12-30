package com.sun.hibernate.dao.hbm;

import java.util.Date;

public class HistoryMessage {
	public static final int STATE_RECEIVED_TIME			=	0;//定时
	public static final int STATE_RECEIVED_OFFLINE		=	1;//离线
	public static final int STATE_SENDED				=	2;//发送出去
	
	public static final String ContentType_CPIM				= "Message/CPIM";
	public static final String ContentType_TextPlain		= "text/plain";
	public static final String ContentType_Pushinfo_Group	= "text/pushinfo-group";
	public static final String ContentType_Pushinfo_Person	= "text/pushinfo-person";
	
	private int id;
	
	/*
	 * 其中localMsgId sender reciver 三者联合唯一  ，考虑到可能是来自
	 * 同一发送者的群组或接收列表消息
	 */
	private String localMsgId;
	private String sender;
	private String receiver;
	
	//两个日期 服务器日期是用来保证休息的先后顺序
	private Date clientDate; 
	private Date serverDate;
	private String message;//即时消息内容体本身
	private String type;//消息类型
	private int state;//消息体处于的状态
	
	
	
	
	//后期为历史和定时消息查询添加的字段
	private String subject;//sip消息头主题字段
	//private Date expiry;//
	private Date timeToDeliver;//定时消息类型专属字段   何时发送
	
	//对指定历史消息和指定定时消息的查询返回响应中需要该字段     同时该字段兼职了记录历史消息过期时间的功能
	//历史消息过期时间  计算方法为从imserver发出去后+系统配置指定的过期时长
	private Date sendedTime;
	
	private String msgReport;//是否需要递送报告  yes no   指定消息和历史消息列表的响应中都需要该字段

	public String getMsgReport() {
		return msgReport;
	}
	public void setMsgReport(String msgReport) {
		this.msgReport = msgReport;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getTimeToDeliver() {
		return timeToDeliver;
	}
	public void setTimeToDeliver(Date timeToDeliver) {
		this.timeToDeliver = timeToDeliver;
	}
	public Date getSendedTime() {
		return sendedTime;
	}
	public void setSendedTime(Date sendedTime) {
		this.sendedTime = sendedTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocalMsgId() {
		return localMsgId;
	}
	public void setLocalMsgId(String localMsgId) {
		this.localMsgId = localMsgId;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public Date getClientDate() {
		return clientDate;
	}
	public void setClientDate(Date clientDate) {
		this.clientDate = clientDate;
	}
	public Date getServerDate() {
		return serverDate;
	}
	public void setServerDate(Date serverDate) {
		this.serverDate = serverDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer("\n");
		
		sb.append("--> MESSAGE ID: ").append(localMsgId).append("\n");
		sb.append("Sender: ").append(sender).append("\n");
		sb.append("Receiver: ").append(receiver).append("\n");
		sb.append("Time: ").append(serverDate).append("\n");
		sb.append("MsgType: ").append(type).append("\n");
		sb.append("Status: ").append(state).append("\n");
		sb.append("Content: ").append(message).append("\n");
		
		return sb.toString();
	}
}
