package com.livfast.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="productwarranty_tbl")
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "finalProductWarrenty_tbl",procedureName = "finalProductWarrenty_tbl")})
public class LivFastProductWarrenty 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_phone")
	private String phone;
	
	@Column(name="vehicle_number")
	private String vehicleNumber;
	
	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimeStamp;
	
	@Column(name="updated_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimeStamp;
	
	@Column(name = "vehicle_model_id")
	private int vehicleModelId;
	
	@Column(name="large_image")
	private String largeImageLink;
	
	@Column(name="small_image")
	private String smallImageLink;
	
	@Column(name="warranty")
	private String warrenty;
	
	@Column(name="car_segment_id")
	private int carSegmentId;
	
	@Column(name="vehicle_manufacturer_id")
	private int vehicleMafId;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="loyalty_points")
	private int loyaltyPoint;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="dealer_product")
	private String dealerProduct;
	
	@Column(name="sell_date")
	private String sellDate;
	
	@Column(name="pincode")
	private String pinCode;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private int state;
	
	@Column(name="distributor_code")
	private String distributorCode;
	
	@Column(name="distributor_name")
	private int distributorName;
	
	@Column(name="product_cat")
	private int productCategory;
	
	@Column(name="exchange_qwicksilver")
	private int exchangeQwickSilver;
	
	@Column(name="with_otp")
	private int withOtp;

	/**
	 * 
	 */
	public LivFastProductWarrenty() 
	{}

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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the vehicleNumber
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}

	/**
	 * @param vehicleNumber the vehicleNumber to set
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
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
	 * @return the vehicleModelId
	 */
	public int getVehicleModelId() {
		return vehicleModelId;
	}

	/**
	 * @param vehicleModelId the vehicleModelId to set
	 */
	public void setVehicleModelId(int vehicleModelId) {
		this.vehicleModelId = vehicleModelId;
	}

	/**
	 * @return the largeImageLink
	 */
	public String getLargeImageLink() {
		return largeImageLink;
	}

	/**
	 * @param largeImageLink the largeImageLink to set
	 */
	public void setLargeImageLink(String largeImageLink) {
		this.largeImageLink = largeImageLink;
	}

	/**
	 * @return the smallImageLink
	 */
	public String getSmallImageLink() {
		return smallImageLink;
	}

	/**
	 * @param smallImageLink the smallImageLink to set
	 */
	public void setSmallImageLink(String smallImageLink) {
		this.smallImageLink = smallImageLink;
	}

	/**
	 * @return the warrenty
	 */
	public String getWarrenty() {
		return warrenty;
	}

	/**
	 * @param warrenty the warrenty to set
	 */
	public void setWarrenty(String warrenty) {
		this.warrenty = warrenty;
	}

	/**
	 * @return the carSegmentId
	 */
	public int getCarSegmentId() {
		return carSegmentId;
	}

	/**
	 * @param carSegmentId the carSegmentId to set
	 */
	public void setCarSegmentId(int carSegmentId) {
		this.carSegmentId = carSegmentId;
	}

	/**
	 * @return the vehicleMafId
	 */
	public int getVehicleMafId() {
		return vehicleMafId;
	}

	/**
	 * @param vehicleMafId the vehicleMafId to set
	 */
	public void setVehicleMafId(int vehicleMafId) {
		this.vehicleMafId = vehicleMafId;
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
	 * @return the dealerProduct
	 */
	public String getDealerProduct() {
		return dealerProduct;
	}

	/**
	 * @param dealerProduct the dealerProduct to set
	 */
	public void setDealerProduct(String dealerProduct) {
		this.dealerProduct = dealerProduct;
	}

	/**
	 * @return the sellDate
	 */
	public String getSellDate() {
		return sellDate;
	}

	/**
	 * @param sellDate the sellDate to set
	 */
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}

	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the distributorCode
	 */
	public String getDistributorCode() {
		return distributorCode;
	}

	/**
	 * @param distributorCode the distributorCode to set
	 */
	public void setDistributorCode(String distributorCode) {
		this.distributorCode = distributorCode;
	}

	/**
	 * @return the distributorName
	 */
	public int getDistributorName() {
		return distributorName;
	}

	/**
	 * @param distributorName the distributorName to set
	 */
	public void setDistributorName(int distributorName) {
		this.distributorName = distributorName;
	}

	/**
	 * @return the productCategory
	 */
	public int getProductCategory() {
		return productCategory;
	}

	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(int productCategory) {
		this.productCategory = productCategory;
	}

	/**
	 * @return the exchangeQwickSilver
	 */
	public int getExchangeQwickSilver() {
		return exchangeQwickSilver;
	}

	/**
	 * @param exchangeQwickSilver the exchangeQwickSilver to set
	 */
	public void setExchangeQwickSilver(int exchangeQwickSilver) {
		this.exchangeQwickSilver = exchangeQwickSilver;
	}

	/**
	 * @return the withOtp
	 */
	public int getWithOtp() {
		return withOtp;
	}

	/**
	 * @param withOtp the withOtp to set
	 */
	public void setWithOtp(int withOtp) {
		this.withOtp = withOtp;
	}

	/**
	 * @param id
	 * @param customerName
	 * @param phone
	 * @param vehicleNumber
	 * @param createdTimeStamp
	 * @param updatedTimeStamp
	 * @param vehicleModelId
	 * @param largeImageLink
	 * @param smallImageLink
	 * @param warrenty
	 * @param carSegmentId
	 * @param vehicleMafId
	 * @param serialNumber
	 * @param loyaltyPoint
	 * @param userId
	 * @param dealerProduct
	 * @param sellDate
	 * @param pinCode
	 * @param city
	 * @param state
	 * @param distributorCode
	 * @param distributorName
	 * @param productCategory
	 * @param exchangeQwickSilver
	 * @param withOtp
	 */
	public LivFastProductWarrenty(int id, String customerName, String phone, String vehicleNumber, Date createdTimeStamp,
			Date updatedTimeStamp, int vehicleModelId, String largeImageLink, String smallImageLink, String warrenty,
			int carSegmentId, int vehicleMafId, String serialNumber, int loyaltyPoint, int userId, String dealerProduct,
			String sellDate, String pinCode, String city, int state, String distributorCode, int distributorName,
			int productCategory, int exchangeQwickSilver, int withOtp) {
		this.id = id;
		this.customerName = customerName;
		this.phone = phone;
		this.vehicleNumber = vehicleNumber;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.vehicleModelId = vehicleModelId;
		this.largeImageLink = largeImageLink;
		this.smallImageLink = smallImageLink;
		this.warrenty = warrenty;
		this.carSegmentId = carSegmentId;
		this.vehicleMafId = vehicleMafId;
		this.serialNumber = serialNumber;
		this.loyaltyPoint = loyaltyPoint;
		this.userId = userId;
		this.dealerProduct = dealerProduct;
		this.sellDate = sellDate;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.distributorCode = distributorCode;
		this.distributorName = distributorName;
		this.productCategory = productCategory;
		this.exchangeQwickSilver = exchangeQwickSilver;
		this.withOtp = withOtp;
	}

	@Override
	public String toString() {
		return "LivFastProductWarrenty [id=" + id + ", customerName=" + customerName + ", phone=" + phone + ", vehicleNumber="
				+ vehicleNumber + ", createdTimeStamp=" + createdTimeStamp + ", updatedTimeStamp=" + updatedTimeStamp
				+ ", vehicleModelId=" + vehicleModelId + ", largeImageLink=" + largeImageLink + ", smallImageLink="
				+ smallImageLink + ", warrenty=" + warrenty + ", carSegmentId=" + carSegmentId + ", vehicleMafId="
				+ vehicleMafId + ", serialNumber=" + serialNumber + ", loyaltyPoint=" + loyaltyPoint + ", userId="
				+ userId + ", dealerProduct=" + dealerProduct + ", sellDate=" + sellDate + ", pinCode=" + pinCode
				+ ", city=" + city + ", state=" + state + ", distributorCode=" + distributorCode + ", distributorName="
				+ distributorName + ", productCategory=" + productCategory + ", exchangeQwickSilver="
				+ exchangeQwickSilver + ", withOtp=" + withOtp + "]";
	}

	
	
	
}
