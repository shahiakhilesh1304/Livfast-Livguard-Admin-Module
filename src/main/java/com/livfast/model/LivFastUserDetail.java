package com.livfast.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name="api_userdetail")
public class LivFastUserDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="address")
	private String address;
	
	@Column(name="dealership_name")
	private String dealerShipName;
	
	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimeStamp;
	
	@Column(name="updated_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimeStamp;
	
	@OneToOne(targetEntity = LivFastAuthUser.class,cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "user_id")
	private String userId;
	
	@Column(name="verification_otp")
	private String verifOTP;
	
	@Column(name="verification_status")
	private String verifStatus;
	
	@Column(name="large_image")
	private String LargeImageLink;
	
	@Column(name="small_image")
	private String samllImageLink;
	
	@Column(name="total_loyalty")
	private int totalLoyalty;
	
	@Column(name="salespersonname")
	private String saleManName;
	
	@Column(name="city")
	private String city;
	
	@Column(name="pincode")
	private String areaCode;
	
	@Column(name="salespersoncode")
	private String saleManCode;
	
	@Column(name="state")
	private String state;
	
	@Column(name="distributor_code")
	private String distributorCode;
	
	@Column(name="distributor_name")
	private String distributorName;
	
	@Column(name="type")
	private int type;
	
	@Column(name="distributor_zone")
	private String distributorZone;
	
	@Column(name="erick_loyalty")
	private int erickLoyalty;
	
	@Column(name="total_loyalty_tertiary")
	private int tertiaryLoyalty;
	
	@Column(name="erick_tert_loyalty")
	private int erickTertLoyalty;
	
	@Column(name="joining_bonus")
	private int joiningBonus;
	
	@Column(name="ibups_sec_loyalty")
	private int ibupsSecLoyalty;
	
	@Column(name="fourw_sec_loyalty")
	private int fourwSecLoyalty;

	public LivFastUserDetail() 
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the dealerShipName
	 */
	public String getDealerShipName() {
		return dealerShipName;
	}

	/**
	 * @param dealerShipName the dealerShipName to set
	 */
	public void setDealerShipName(String dealerShipName) {
		this.dealerShipName = dealerShipName;
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
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the verifOTP
	 */
	public String getVerifOTP() {
		return verifOTP;
	}

	/**
	 * @param verifOTP the verifOTP to set
	 */
	public void setVerifOTP(String verifOTP) {
		this.verifOTP = verifOTP;
	}

	/**
	 * @return the verifStatus
	 */
	public String getVerifStatus() {
		return verifStatus;
	}

	/**
	 * @param verifStatus the verifStatus to set
	 */
	public void setVerifStatus(String verifStatus) {
		this.verifStatus = verifStatus;
	}

	/**
	 * @return the largeImageLink
	 */
	public String getLargeImageLink() {
		return LargeImageLink;
	}

	/**
	 * @param largeImageLink the largeImageLink to set
	 */
	public void setLargeImageLink(String largeImageLink) {
		LargeImageLink = largeImageLink;
	}

	/**
	 * @return the samllImageLink
	 */
	public String getSamllImageLink() {
		return samllImageLink;
	}

	/**
	 * @param samllImageLink the samllImageLink to set
	 */
	public void setSamllImageLink(String samllImageLink) {
		this.samllImageLink = samllImageLink;
	}

	/**
	 * @return the totalLoyalty
	 */
	public int getTotalLoyalty() {
		return totalLoyalty;
	}

	/**
	 * @param totalLoyalty the totalLoyalty to set
	 */
	public void setTotalLoyalty(int totalLoyalty) {
		this.totalLoyalty = totalLoyalty;
	}

	/**
	 * @return the saleManName
	 */
	public String getSaleManName() {
		return saleManName;
	}

	/**
	 * @param saleManName the saleManName to set
	 */
	public void setSaleManName(String saleManName) {
		this.saleManName = saleManName;
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
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the saleManCode
	 */
	public String getSaleManCode() {
		return saleManCode;
	}

	/**
	 * @param saleManCode the saleManCode to set
	 */
	public void setSaleManCode(String saleManCode) {
		this.saleManCode = saleManCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the distributorZone
	 */
	public String getDistributorZone() {
		return distributorZone;
	}

	/**
	 * @param distributorZone the distributorZone to set
	 */
	public void setDistributorZone(String distributorZone) {
		this.distributorZone = distributorZone;
	}

	/**
	 * @return the erickLoyalty
	 */
	public int getErickLoyalty() {
		return erickLoyalty;
	}

	/**
	 * @param erickLoyalty the erickLoyalty to set
	 */
	public void setErickLoyalty(int erickLoyalty) {
		this.erickLoyalty = erickLoyalty;
	}

	/**
	 * @return the tertiaryLoyalty
	 */
	public int getTertiaryLoyalty() {
		return tertiaryLoyalty;
	}

	/**
	 * @param tertiaryLoyalty the tertiaryLoyalty to set
	 */
	public void setTertiaryLoyalty(int tertiaryLoyalty) {
		this.tertiaryLoyalty = tertiaryLoyalty;
	}

	/**
	 * @return the erickTertLoyalty
	 */
	public int getErickTertLoyalty() {
		return erickTertLoyalty;
	}

	/**
	 * @param erickTertLoyalty the erickTertLoyalty to set
	 */
	public void setErickTertLoyalty(int erickTertLoyalty) {
		this.erickTertLoyalty = erickTertLoyalty;
	}

	/**
	 * @return the joiningBonus
	 */
	public int getJoiningBonus() {
		return joiningBonus;
	}

	/**
	 * @param joiningBonus the joiningBonus to set
	 */
	public void setJoiningBonus(int joiningBonus) {
		this.joiningBonus = joiningBonus;
	}

	/**
	 * @return the ibupsSecLoyalty
	 */
	public int getIbupsSecLoyalty() {
		return ibupsSecLoyalty;
	}

	/**
	 * @param ibupsSecLoyalty the ibupsSecLoyalty to set
	 */
	public void setIbupsSecLoyalty(int ibupsSecLoyalty) {
		this.ibupsSecLoyalty = ibupsSecLoyalty;
	}

	/**
	 * @return the fourwSecLoyalty
	 */
	public int getFourwSecLoyalty() {
		return fourwSecLoyalty;
	}

	/**
	 * @param fourwSecLoyalty the fourwSecLoyalty to set
	 */
	public void setFourwSecLoyalty(int fourwSecLoyalty) {
		this.fourwSecLoyalty = fourwSecLoyalty;
	}

	public LivFastUserDetail(int id, String phone, String address, String dealerShipName, Date createdTimeStamp,
			Date updatedTimeStamp, String userId, String verifOTP, String verifStatus, String largeImageLink,
			String samllImageLink, int totalLoyalty, String saleManName, String city, String areaCode,
			String saleManCode, String state, String distributorCode, String distributorName, int type,
			String distributorZone, int erickLoyalty, int tertiaryLoyalty, int erickTertLoyalty, int joiningBonus,
			int ibupsSecLoyalty, int fourwSecLoyalty) 
	{
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.dealerShipName = dealerShipName;
		this.createdTimeStamp = createdTimeStamp;
		this.updatedTimeStamp = updatedTimeStamp;
		this.userId = userId;
		this.verifOTP = verifOTP;
		this.verifStatus = verifStatus;
		LargeImageLink = largeImageLink;
		this.samllImageLink = samllImageLink;
		this.totalLoyalty = totalLoyalty;
		this.saleManName = saleManName;
		this.city = city;
		this.areaCode = areaCode;
		this.saleManCode = saleManCode;
		this.state = state;
		this.distributorCode = distributorCode;
		this.distributorName = distributorName;
		this.type = type;
		this.distributorZone = distributorZone;
		this.erickLoyalty = erickLoyalty;
		this.tertiaryLoyalty = tertiaryLoyalty;
		this.erickTertLoyalty = erickTertLoyalty;
		this.joiningBonus = joiningBonus;
		this.ibupsSecLoyalty = ibupsSecLoyalty;
		this.fourwSecLoyalty = fourwSecLoyalty;
	}

	@Override
	public String toString() {
		return "LivFastUserDetail [id=" + id + ", phone=" + phone + ", address=" + address + ", dealerShipName="
				+ dealerShipName + ", createdTimeStamp=" + createdTimeStamp + ", updatedTimeStamp=" + updatedTimeStamp
				+ ", userId=" + userId + ", verifOTP=" + verifOTP + ", verifStatus=" + verifStatus + ", LargeImageLink="
				+ LargeImageLink + ", samllImageLink=" + samllImageLink + ", totalLoyalty=" + totalLoyalty
				+ ", saleManName=" + saleManName + ", city=" + city + ", areaCode=" + areaCode + ", saleManCode="
				+ saleManCode + ", state=" + state + ", distributorCode=" + distributorCode + ", distributorName="
				+ distributorName + ", type=" + type + ", distributorZone=" + distributorZone + ", erickLoyalty="
				+ erickLoyalty + ", tertiaryLoyalty=" + tertiaryLoyalty + ", erickTertLoyalty=" + erickTertLoyalty
				+ ", joiningBonus=" + joiningBonus + ", ibupsSecLoyalty=" + ibupsSecLoyalty + ", fourwSecLoyalty="
				+ fourwSecLoyalty + "]";
	}
}
