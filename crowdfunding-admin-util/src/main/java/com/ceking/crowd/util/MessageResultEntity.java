package com.ceking.crowd.util;

import com.google.gson.Gson;

public class MessageResultEntity {

	private String status;
	private String send_id;
	private Integer fee;
	private String sms_credits;
	private String transactional_sms_credits;
	private String code;
	private String msg;

	public static MessageResultEntity convertJsonToMessageResultEntity(String json) {
		Gson gson = new Gson();
		MessageResultEntity resultEntity = gson.fromJson(json, MessageResultEntity.class);
		return resultEntity;
	}

	public MessageResultEntity() {
		super();
	}

	public MessageResultEntity(String status, String send_id, Integer fee, String sms_credits,
			String transactional_sms_credits, String code, String msg) {
		super();
		this.status = status;
		this.send_id = send_id;
		this.fee = fee;
		this.sms_credits = sms_credits;
		this.transactional_sms_credits = transactional_sms_credits;
		this.code = code;
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSend_id() {
		return send_id;
	}

	public void setSend_id(String send_id) {
		this.send_id = send_id;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public String getSms_credits() {
		return sms_credits;
	}

	public void setSms_credits(String sms_credits) {
		this.sms_credits = sms_credits;
	}

	public String getTransactional_sms_credits() {
		return transactional_sms_credits;
	}

	public void setTransactional_sms_credits(String transactional_sms_credits) {
		this.transactional_sms_credits = transactional_sms_credits;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "MessageResultEntity [status=" + status + ", send_id=" + send_id + ", fee=" + fee + ", sms_credits="
				+ sms_credits + ", transactional_sms_credits=" + transactional_sms_credits + ", code=" + code + ", msg="
				+ msg + "]";
	}
	
	
}
