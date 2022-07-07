package com.livfast.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "api_batteryscheme")
public class LivFastScheme 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="scheme_name")
	private String schemeName;
	
	@Column(name="scheme_detail")
	private String schemeDetail;
	
	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp;
	
	@Column(name="updated_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimestamp;
	
	@Column(name="conversion_ratio")
	private Long conversionRatio;
	
	@Column(name="is_manual")
	private String isManual;
	
	@Column(name="end_timestamp")
	@Temporal(TemporalType.DATE)
	private Date endTimestamp;
	
	@Column(name="start_timestamp")
	@Temporal(TemporalType.DATE)
	private Date startTimestamp;
	
	@Column(name="scheme_scandate")
	@Temporal(TemporalType.DATE)
	private Date schemeScandate;

	public LivFastScheme(int id, String schemeName, String schemeDetail, Date createdTimestamp, Date updatedTimestamp,
			Long conversionRatio, String isManual, Date endTimestamp, Date startTimestamp, Date schemeScandate) {
		this.id = id;
		this.schemeName = schemeName;
		this.schemeDetail = schemeDetail;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.conversionRatio = conversionRatio;
		this.isManual = isManual;
		this.endTimestamp = endTimestamp;
		this.startTimestamp = startTimestamp;
		this.schemeScandate = schemeScandate;
	}

	public LivFastScheme()
	{}

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

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
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

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getSchemeScandate() {
		return schemeScandate;
	}

	public void setSchemeScandate(Date schemeScandate) {
		this.schemeScandate = schemeScandate;
	}

	@Override
	public String toString() {
		return "Scheme [id=" + id + ", schemeName=" + schemeName + ", schemeDetail=" + schemeDetail
				+ ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp
				+ ", conversionRatio=" + conversionRatio + ", isManual=" + isManual + ", endTimestamp=" + endTimestamp
				+ ", startTimestamp=" + startTimestamp + ", schemeScandate=" + schemeScandate + "]";
	}
	
}
