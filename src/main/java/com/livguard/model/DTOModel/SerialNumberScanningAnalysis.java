package com.livguard.model.DTOModel;



import org.springframework.stereotype.Component;

@Component
public class SerialNumberScanningAnalysis 
{
	private int month;
	private int week;
	private int numberOfSerialNumber;
	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}
	/**
	 * @return the week
	 */
	public int getWeek() {
		return week;
	}
	/**
	 * @param week the week to set
	 */
	public void setWeek(int week) {
		this.week = week;
	}
	/**
	 * @param  
	 * @return the numberOfSerialNumber
	 */
	public int getNumberOfSerialNumber() {
		return numberOfSerialNumber;
	}
	
	/**
	 * @param numberOfSerialNumber the numberOfSerialNumber to set
	 */
	public void setNumberOfSerialNumber(int numberOfSerialNumber) {
		this.numberOfSerialNumber = numberOfSerialNumber;
	}
	
	/**
	 * 
	 */
	public SerialNumberScanningAnalysis() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param month
	 * @param week
	 * @param numberOfSerialNumber
	 */
	public SerialNumberScanningAnalysis(int month, int week, int numberOfSerialNumber) {
		this.month = month;
		this.week = week;
		this.numberOfSerialNumber = numberOfSerialNumber;
	}
	
	@Override
	public String toString() {
		return "SerialNumberScanningAnalysis [month=" + month + ", week=" + week + ", numberOfSerialNumber="
				+ numberOfSerialNumber + "]";
	}
	
	
}
