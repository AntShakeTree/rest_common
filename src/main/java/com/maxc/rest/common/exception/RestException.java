package com.maxc.rest.common.exception;

public class RestException extends RuntimeException {
	public RestException() {
	}

	public RestException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RestException(String arg0) {
		super(arg0);
	}

	public RestException(Throwable arg0) {
		super(arg0);

	}

	private static final long serialVersionUID = -105239594247548881L;

	private int code;
	public String message;
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return code;
	}

	public void setErrorCode(int code) {
		this.code = code;
	}
}
