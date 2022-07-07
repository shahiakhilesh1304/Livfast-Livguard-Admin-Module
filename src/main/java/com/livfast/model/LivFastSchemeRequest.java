package com.livfast.model;

import java.util.Date;

public class LivFastSchemeRequest 
{
	private int id;
	private String schemeName;
	private String schemeDetail;
	private Long conversionRatio;
	private String isManual;
	private String startTimestamp;
	private String endTimestamp;
	private String schemeScandate;
	private String schemeState;
	private boolean fourW;
	private boolean ibUPS;
	private boolean eRickShaw;
	private Date createdTimestamp;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getSchemeDetail() {
		return schemeDetail;
	}
	public void setSchemeDetail(String schemeDetail) {
		this.schemeDetail = schemeDetail;
	}
	public Long getConversionRatio() {
		return conversionRatio;
	}
	public void setConversionRatio(Long conversionRatio) {
		this.conversionRatio = conversionRatio;
	}
	public String getIsManual() {
		return isManual;
	}
	public void setIsManual(String isManual) {
		this.isManual = isManual;
	}
	public String getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(String endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
	public String getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(String startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public String getSchemeScandate() {
		return schemeScandate;
	}
	public void setSchemeScandate(String schemeScandate) {
		this.schemeScandate = schemeScandate;
	}
	public String getSchemeState() {
		return schemeState;
	}
	public void setSchemeState(String schemeState) {
		this.schemeState = schemeState;
	}
	public boolean getFourW() {
		return fourW;
	}
	public void setFourW(boolean fourW) {
		this.fourW = fourW;
	}
	public boolean getIbUPS() {
		return ibUPS;
	}
	public void setIbUPS(boolean ibUPS) {
		this.ibUPS = ibUPS;
	}
	public boolean geteRickShaw() {
		return eRickShaw;
	}
	public void seteRickShaw(boolean eRickShaw) {
		this.eRickShaw = eRickShaw;
	}
	/**
	 * @return the createdTimestamp
	 */
	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}
	/**
	 * @param createdTimestamp the createdTimestamp to set
	 */
	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
	
	
}
