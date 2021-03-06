package com.ceking.crowd.exception;

/**
 * 用户账户重复异常
 * @author cjq
 *
 */
public class LoginAcctDuplicateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginAcctDuplicateException() {
		super();
	}

	public LoginAcctDuplicateException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LoginAcctDuplicateException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LoginAcctDuplicateException(String arg0) {
		super(arg0);
	}

	public LoginAcctDuplicateException(Throwable arg0) {
		super(arg0);
	}
	

}
