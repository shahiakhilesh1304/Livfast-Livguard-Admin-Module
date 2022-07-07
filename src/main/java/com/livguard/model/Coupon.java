package com.livguard.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "coupon_table")

@DynamicInsert
@DynamicUpdate
public class Coupon 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="coupon_text")
	private String couponText;		

	@Column(name="redeem_status")
	private String redeemStatus;

	@Column(name="coupon_scratch_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date couponScratchDate;

	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp;

	@Column(name="user_id")
	private int userId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "coupon_status")
	private Status status;
	
	public Coupon()
	{}		

	public Coupon(String userName, String couponText, String redeemStatus, Date couponScratchDate,
			Date createdTimestamp, int userId, Status status) {
		this.userName = userName;
		this.couponText = couponText;
		this.redeemStatus = redeemStatus;
		this.couponScratchDate = couponScratchDate;
		this.createdTimestamp = createdTimestamp;
		this.userId = userId;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCouponText() {
		return couponText;
	}

	public void setCouponText(String couponText) {
		this.couponText = couponText;
	}

	public String getRedeemStatus() {
		return redeemStatus;
	}

	public void setRedeemStatus(String redeemStatus) {
		this.redeemStatus = redeemStatus;
	}

	public Date getCouponScratchDate() {
		return couponScratchDate;
	}

	public void setCouponScratchDate(Date couponScratchDate) {
		this.couponScratchDate = couponScratchDate;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Coupon [id=" + id + ", userName=" + userName + ", couponText=" + couponText + ", redeemStatus="
				+ redeemStatus + ", couponScratchDate=" + couponScratchDate + ", createdTimestamp="
				+ createdTimestamp + ", userId=" + userId + ", status=" + status + "]";
	}	
}
