package com.livguard.model.DTOModel;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SchemeAvailable 
{
	private Date createdTime;
	private int count;
	/**
	 * 
	 */
	public SchemeAvailable() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param createdTime
	 * @param count
	 */
	public SchemeAvailable(Date createdTime, int count) {
		this.createdTime = createdTime;
		this.count = count;
	}
	/**
	 * @return the createdTime
	 */
	public Date getCreatedTime() {
		return createdTime;
	}
	/**
	 * @param createdTime the createdTime to set
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "SchemeAvailable [createdTime=" + createdTime + ", count=" + count + "]";
	}
	
	
	
}
