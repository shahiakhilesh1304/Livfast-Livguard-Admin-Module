package com.livguard.model;

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
@Table(name = "api_dealerproduct")
public class DealerProduct 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="unique_code")
	private String uniqueCode;

	@Column(name="comment")
	private String comment;

	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimeStamp;
	
	@Column(name="updated_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimeStamp;
	
	@Column(name="product_id")
	private int productId;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="offer_id")
	private String offerId;
	
	@Column(name="distributor_name")
	private String distributorName;
	
	@Column(name="distributor_code")
	private int distributorCode;

	/**
	 * 
	 */
	public DealerProduct() {
		// TODO Auto-generated constructor stub
	}

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
	 * @return the uniqueCode
	 */
	public String getUniqueCode() {
		return uniqueCode;
	}

	/**
	 * @param uniqueCode the uniqueCode to set
	 */
	public void setUniqueCode(String uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the offerId
	 */
	public String getOfferId() {
		return offerId;
	}

	/**
	 * @param offerId the offerId to set
	 */
	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	/**
	 * @return the distributorName
	 */
	public String getDistributorName() {
		return distributorName;
	}

	/**
	 * @param distributorName the distributorName to set
	 */
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	/**
	 * @return the distributorCode
	 */
	public int getDistributorCode() {
		return distributorCode;
	}

	/**
	 * @param distributorCode the distributorCode to set
	 */
	public void setDistributorCode(int distributorCode) {
		this.distributorCode = distributorCode;
	}

	/**
	 * @param id
	 * @param uniqueCode
	 * @param comment
	 * @param createdTimeStamp
	 * @param updatedTimeStamp
	 * @param productId
	 * @param userId
	 * @param serialNumber
	 * @param offerId
	 * @param distributorName
	 * @param distributorCode
	 */
	public DealerProduct(int id, String uniqueCode, String comment, Date createdTimeStamp, Date updatedTimeStamp,
			int productId, int userId, String serialNumber, String offerId, String distributorName,
			int distributorCode) {
		this.id = id;
		this.uniqueCode = uniqueCode;
		this.comment = comment;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.productId = productId;
		this.userId = userId;
		this.serialNumber = serialNumber;
		this.offerId = offerId;
		this.distributorName = distributorName;
		this.distributorCode = distributorCode;
	}

	@Override
	public String toString() {
		return "DealerProduct [id=" + id + ", uniqueCode=" + uniqueCode + ", comment=" + comment + ", createdTimeStamp="
				+ createdTimeStamp + ", updatedTimeStamp=" + updatedTimeStamp + ", productId=" + productId + ", userId="
				+ userId + ", serialNumber=" + serialNumber + ", offerId=" + offerId + ", distributorName="
				+ distributorName + ", distributorCode=" + distributorCode + "]";
	}
	
	
	
}
