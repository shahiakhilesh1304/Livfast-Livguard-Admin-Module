package com.livguard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "api_batterymodelseligiblescheme")

@DynamicInsert
@DynamicUpdate
public class SecondaryScheme 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="brand_name")
	private String brandName;
	
	@Column(name="`range`")
	private String range;
	
	@Column(name="product_desc")
	private String productDesc;
	
	@Column(name="loyalty_points")
	private int loyaltyPoints;
	
	@Column(name="battery_scheme_id")
	private int batterySchemeId;

	public SecondaryScheme()
	{}
	
	public SecondaryScheme(String productName, String brandName, String range, String productDesc,
			int loyaltyPoints, int batterySchemeId) {
		this.productName = productName;
		this.brandName = brandName;
		this.range = range;
		this.productDesc = productDesc;
		this.loyaltyPoints = loyaltyPoints;
		this.batterySchemeId = batterySchemeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	public int getBatterySchemeId() {
		return batterySchemeId;
	}

	public void setBatterySchemeId(int batterySchemeId) {
		this.batterySchemeId = batterySchemeId;
	}

	@Override
	public String toString() {
		return "SecondaryScheme [id=" + id + ", productName=" + productName + ", brandName=" + brandName + ", range="
				+ range + ", productDesc=" + productDesc + ", loyaltyPoints=" + loyaltyPoints + ", batterySchemeId="
				+ batterySchemeId + "]";
	}	
}
