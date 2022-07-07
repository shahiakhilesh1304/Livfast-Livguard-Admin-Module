package com.mongodsc.model;

import java.util.Arrays;

public class Data 
{
	private Object data;

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data [data=" + data + "]";
	}

	public Data(Object data) {
		this.data = data;
	}

	public Data() {
		// TODO Auto-generated constructor stub
	}
	
}
