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
@Table(name="monthly_slabs")
public class LivFastMonthlySlabs 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="loyalty_point")
	private int loyaltyPoint;
	
	@Column(name="is_active",insertable = false, updatable = false)
	private Boolean isActive;
	
	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimeStamp;
	
	@Column(name="updated_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimeStamp;
	
	@Column(name="battery_scheme_id")
	private int batterySchemeId;
	
	@Column(name="redeem_desc")
	private String redeemDesc;

	/**
	 * 
	 */
	public LivFastMonthlySlabs() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the loyaltyPoint
	 */
	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	/**
	 * @param loyaltyPoint the loyaltyPoint to set
	 */
	public void setLoyaltyPoint(int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the createdTimeStamp
	 */
	public Date getCreatedTimeStamp() {
		return createdTimeStamp;
	}

	/**
	 * @param createdTimeStamp the createdTimeStamp to set
	 */
	public void setCreatedTimeStamp(Date createdTimeStamp) {
		this.createdTimeStamp = createdTimeStamp;
	}

	/**
	 * @return the updatedTimeStamp
	 */
	public Date getUpdatedTimeStamp() {
		return updatedTimeStamp;
	}

	/**
	 * @param updatedTimeStamp the updatedTimeStamp to set
	 */
	public void setUpdatedTimeStamp(Date updatedTimeStamp) {
		this.updatedTimeStamp = updatedTimeStamp;
	}

	/**
	 * @return the batterySchemeId
	 */
	public int getBatterySchemeId() {
		return batterySchemeId;
	}

	/**
	 * @param batterySchemeId the batterySchemeId to set
	 */
	public void setBatterySchemeId(int batterySchemeId) {
		this.batterySchemeId = batterySchemeId;
	}

	/**
	 * @return the redeemDesc
	 */
	public String getRedeemDesc() {
		return redeemDesc;
	}

	/**
	 * @param redeemDesc the redeemDesc to set
	 */
	public void setRedeemDesc(String redeemDesc) {
		this.redeemDesc = redeemDesc;
	}

	/**
	 * @param id
	 * @param loyaltyPoint
	 * @param isActive
	 * @param createdTimeStamp
	 * @param updatedTimeStamp
	 * @param batterySchemeId
	 * @param redeemDesc
	 */
	public LivFastMonthlySlabs(int id, int loyaltyPoint, Boolean isActive, Date createdTimeStamp, Date updatedTimeStamp,
			int batterySchemeId, String redeemDesc) {
		this.id = id;
		this.loyaltyPoint = loyaltyPoint;
		this.isActive = isActive;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.batterySchemeId = batterySchemeId;
		this.redeemDesc = redeemDesc;
	}

	@Override
	public String toString() {
		return "LivFastMonthlySlabs [id=" + id + ", loyaltyPoint=" + loyaltyPoint + ", isActive=" + isActive
				+ ", createdTimeStamp=" + createdTimeStamp + ", updatedTimeStamp=" + updatedTimeStamp
				+ ", batterySchemeId=" + batterySchemeId + ", redeemDesc=" + redeemDesc + "]";
	}
}
