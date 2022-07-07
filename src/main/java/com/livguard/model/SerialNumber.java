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
@Table(name= "api_specialserialno")

@DynamicInsert
@DynamicUpdate
public class SerialNumber 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="serial_number")
	private String serialNumber;
	
	@Column(name="entry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date entryDate;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	public SerialNumber()
	{}
	
	public SerialNumber(String serialNumber, Date entryDate, Status status) {
		this.serialNumber = serialNumber;
		this.entryDate = entryDate;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "SerialNumber [id=" + id + ", serialNumber=" + serialNumber + ", entryDate=" + entryDate + ", status="
				+ status + "]";
	}
	
}
