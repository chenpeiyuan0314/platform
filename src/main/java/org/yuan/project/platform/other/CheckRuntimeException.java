package org.yuan.project.platform.other;

public class CheckRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CheckRuntimeException(int code) {
		super(CheckExceptionMessage.getInfo(code));
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	private int code;
}
