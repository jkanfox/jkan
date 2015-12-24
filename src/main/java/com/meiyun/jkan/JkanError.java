package com.meiyun.jkan;

import java.io.Serializable;

/**
 * JKAN ERROR Response
 * 
 * @author larry.qi
 */
public class JkanError implements Serializable {

	private static final long serialVersionUID = 6328376886632372580L;

	/**
	 * 错误码
	 */
	private String code;

	/**
	 * 错误内容
	 */
	private String message;

	/**
	 * 自定义错误
	 * @param message
	 */
	public JkanError(String message) {
		super();
		this.setCode("CT100");
		this.message = message;
	}

	public JkanError() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
