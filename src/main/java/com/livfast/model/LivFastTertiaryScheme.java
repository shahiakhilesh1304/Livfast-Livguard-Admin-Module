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

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name= "detailproductloyalty_tbl")

@DynamicInsert
@DynamicUpdate
public class LivFastTertiaryScheme 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="vehicle_manufacturer")
	private String vehicleManufacturer; 
	
	@Column(name="created_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp; 
	
	@Column(name="updated_timestamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimestamp; 
	
	@Column(name="segment")
	private String segment; 
	
	@Column(name="vehicle_model")
	private String vehicleModel;
	
	@Column(name="fuel")
	private String fuel; 
	
	@Column(name="capacity")
	private int capacity; 
	
	@Column(name="livguard_brand")
	private String livguardBrand;
	
	@Column(name="battery_model")
	private String batteryModel;
	
	@Column(name="warranty_month")
	private String warrantyMonth;
	
	@Column(name="`range`")
	private String range; 
	
	@Column(name="points")
	private int points; 
	
	@Column(name="state")
	private String state; 
	
	@Column(name="scheme_id")
	private int schemeId; 
	
	@Column(name="without_otp_point")
	private int withoutOtpPoint;

	public LivFastTertiaryScheme()
	{}
	
	public LivFastTertiaryScheme(String vehicleManufacturer, Date createdTimestamp, Date updatedTimestamp,
			String segment, String vehicleModel, String fuel, int capacity, String livguardBrand, String batteryModel,
			String warrantyMonth, String range, int points, String state, int schemeId, int withoutOtpPoint) {
		this.vehicleManufacturer = vehicleManufacturer;
		this.createdTimestamp = createdTimestamp;
		this.updatedTimestamp = updatedTimestamp;
		this.segment = segment;
		this.vehicleModel = vehicleModel;
		this.fuel = fuel;
		this.capacity = capacity;
		this.livguardBrand = livguardBrand;
		this.batteryModel = batteryModel;
		this.warrantyMonth = warrantyMonth;
		this.range = range;
		this.points = points;
		this.state = state;
		this.schemeId = schemeId;
		this.withoutOtpPoint = withoutOtpPoint;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
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

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getLivguardBrand() {
		return livguardBrand;
	}

	public void setLivguardBrand(String livguardBrand) {
		this.livguardBrand = livguardBrand;
	}

	public String getBatteryModel() {
		return batteryModel;
	}

	public void setBatteryModel(String batteryModel) {
		this.batteryModel = batteryModel;
	}

	public String getWarrantyMonth() {
		return warrantyMonth;
	}

	public void setWarrantyMonth(String warrantyMonth) {
		this.warrantyMonth = warrantyMonth;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(int schemeId) {
		this.schemeId = schemeId;
	}

	public int getWithoutOtpPoint() {
		return withoutOtpPoint;
	}

	public void setWithoutOtpPoint(int withoutOtpPoint) {
		this.withoutOtpPoint = withoutOtpPoint;
	}

	@Override
	public String toString() {
		return "TertiaryScheme [id=" + id + ", vehicleManufacturer=" + vehicleManufacturer + ", createdTimestamp="
				+ createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + ", segment=" + segment
				+ ", vehicleModel=" + vehicleModel + ", fuel=" + fuel + ", capacity=" + capacity + ", livguardBrand="
				+ livguardBrand + ", batteryModel=" + batteryModel + ", warrantyMonth=" + warrantyMonth + ", range="
				+ range + ", points=" + points + ", state=" + state + ", schemeId=" + schemeId + ", withoutOtpPoint="
				+ withoutOtpPoint + "]";
	}
}
