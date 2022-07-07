package com.livguard.model.DTOModel;

import org.springframework.stereotype.Component;

@Component
public class ActiveInActiveUser 
{
	private String month;
	private int active;
	private int inActive;
	/**
	 * 
	 */
	public ActiveInActiveUser() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the active
	 */
	public int getActive() {
		return active;
	}
	/**
	 * @param active the active to set
	 */
	public void setActive(int active) {
		this.active = active;
	}
	/**
	 * @return the inActive
	 */
	public int getInActive() {
		return inActive;
	}
	/**
	 * @param inActive the inActive to set
	 */
	public void setInActive(int inActive) {
		this.inActive = inActive;
	}
	@Override
	public String toString() {
		return "ActiveInActiveUser [month=" + month + ", active=" + active + ", inActive=" + inActive + "]";
	}
	/**
	 * @param month
	 * @param active
	 * @param inActive
	 */
	public ActiveInActiveUser(String month, int active, int inActive) {
		this.month = month;
		this.active = active;
		this.inActive = inActive;
	}
	
	
}
