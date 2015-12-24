package com.meiyun.jkan;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Predicates;

/**
 * 上下文处理核心类
 * @author larry.qi
 */
public class JkanResult implements Serializable {

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
	private JkanError error;

	/**
	 * 自定义扩展属性
	 */
	private Map<String, Object> extra;

	public JkanResult() {
		super();
		success = Boolean.TRUE;
		extra = new HashMap<>();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		autoHandler(success);
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public JkanError getError() {
		return error;
	}

	public void setError(JkanError error) {
		this.error = error;
		autoHandler(success);
	}

	public Map<String, Object> getExtra() {
		return extra;
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
	 * 自动处理对象结果
	 */
	private void autoHandler(boolean success) {
		this.success = success;
		if (success) {
			this.setError(null);
		} else {
			this.setResult(null);
		}
	}

}
