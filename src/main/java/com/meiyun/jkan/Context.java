package com.meiyun.jkan;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Preconditions;

/**
 * 上下文处理核心类
 * @author larry.qi
 */
public class Context implements Serializable {

	private static final long serialVersionUID = -3219055637217466357L;

	/**
	 * 成功标识
	 */
	private boolean success;

	/**
	 * 响应成功的结果集
	 */
	private Object result;

	/**
	 * 错误结果集
	 */
	private Error error;

	/**
	 * 自定义扩展属性
	 */
	private Map<String, Object> extra;
	
	public Context(Object result) {
		this();
		this.result = result;
	}

	public Context() {
		super();
		success = Boolean.TRUE;
		extra = new HashMap<>();
	}

	public boolean isSuccess() {
		return success;
	}

	/**
	 * 根据success来标识
	 * @param success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
		if (success) {
			error = null;
		} else {
			result = null;
		}
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		Preconditions.checkNotNull(result);
		this.setSuccess(Boolean.TRUE);
		this.result = result;
	}

	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		Preconditions.checkNotNull(error);
		this.setSuccess(Boolean.FALSE);
		this.error = error;
	}

	public Map<String, Object> getExtra() {
		return (extra.isEmpty() || !success)? null: extra;
	}

	/**
	 * 添加扩展属性
	 * @param key
	 * @param value
	 */
	public void add(String key, Object value) {
		this.extra.put(key, value);
	}
	
	/**
	 * JKAN ERROR Response
	 * 
	 * @author larry.qi
	 */
	public class Error implements Serializable {

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
		public Error(String message) {
			super();
			this.setCode("CT100");
			this.message = message;
		}

		public Error() {
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
}
