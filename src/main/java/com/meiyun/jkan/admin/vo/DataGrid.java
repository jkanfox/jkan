package com.meiyun.jkan.admin.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 定义EasyUI的DataGrid数据类型
 * @author larry.qi
 *
 */
public class DataGrid<T> implements Serializable {
	
	private static final long serialVersionUID = 6855401753433772729L;

	/**
	 * 总行数
	 */
	private int total;
	
	/**
	 * 数据集
	 */
	private List<T> rows;

	public DataGrid(int total, List<T> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}

	public DataGrid() {
		super();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
