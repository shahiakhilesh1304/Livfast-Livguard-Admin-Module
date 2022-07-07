package com.livguard.model.DTOModel;



import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class UserAnalysis 
{
	private Date entry_date;
	private int userNumber;
	/**
	 * @return the entry_date
	 */
	public Date getEntry_date() {
		return entry_date;
	}
	/**
	 * @param entry_date the entry_date to set
	 */
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	/**
	 * @return the userNumber
	 */
	public int getUserNumber() {
		return userNumber;
	}
	/**
	 * @param userNumber the userNumber to set
	 */
	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}
	
	
	public UserAnalysis(Date entry_date, int userNumber) {
		super();
		this.entry_date = entry_date;
		this.userNumber = userNumber;
	}
	
	public UserAnalysis() {}
	
	@Override
	public String toString() {
		return "UserAnalysis [entry_date=" + entry_date + ", userNumber=" + userNumber + "]";
	}
	
	
}
