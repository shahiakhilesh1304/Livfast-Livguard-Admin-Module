package com.livguard.model.DTOModel;

public class DscRequest 
{
	private String dcode;
	private String jobType;
	/**
	 * @return the dcode
	 */
	public String getDcode() {
		return dcode;
	}
	/**
	 * @param dcode the dcode to set
	 */
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}
	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	@Override
	public String toString() {
		return "DscRequest [dcode=" + dcode + ", jobType=" + jobType + "]";
	}
	public DscRequest(String dcode, String jobType) {
		this.dcode = dcode;
		this.jobType = jobType;
	}
	public DscRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
