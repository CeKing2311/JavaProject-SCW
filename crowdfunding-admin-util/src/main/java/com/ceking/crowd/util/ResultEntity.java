package com.ceking.crowd.util;

import java.awt.Window.Type;

/**
 *统一处理返回结果
 * @author cjq
 *
 * @param <T>
 */
public class ResultEntity<T> {
	public static final String SUCCESS="SUCCESS";
	public static final String FAILED="FAILED";
	//返回结果
	private String result;
	//返回消息
	private String message;
	//返回数据
	private T data;
	
	/**
	 * 返回成功不带数据
	 * @return
	 */
	public static <E> ResultEntity<E> successWithoutData() {
		return new ResultEntity<E>(SUCCESS, null, null);
	}
	/**
	 * 返回成功带数据
	 * @param data
	 * @return
	 */
	public static <E> ResultEntity<E> successWithData(E data) {
		return new ResultEntity<E>(SUCCESS, null, data);
	}
	/**
	 * 返回失败
	 * @param message
	 * @return
	 */
	public static <E> ResultEntity<E> failed(String message) {
		return new ResultEntity<E>(FAILED, message, null);
	}
	
	public ResultEntity() {
		super();
	}

	public ResultEntity(String result, String message, T data) {
		super();
		this.result = result;
		this.message = message;
		this.data = data;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultEntity [result=" + result + ", message=" + message + ", data=" + data + "]";
	}
	
	
}
