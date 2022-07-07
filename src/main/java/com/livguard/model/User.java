package com.livguard.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name= "admin_user")
public class User 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	
	@Column(name="emp_code")
	private String empCode;
	
	private String password;
		
	@Column(name="entry_date")
	private Date entryDate;
	
	private String email;
	
	private String msisdn;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Enumerated(EnumType.STRING)
	private Status status;	
	
	public User()
	{}
	
	public User(String name, String empCode, String password, Date entryDate, String email, String msisdn, Role role, Status status) 
	{
		this.name = name;
		this.empCode = empCode;
		this.password = password;
		this.entryDate = entryDate;
		this.email = email;
		this.msisdn = msisdn;
		this.role = role;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", empCode=" + empCode + ", password=" + password + ", entryDate="
				+ entryDate + ", email=" + email + ", msisdn=" + msisdn + ", role=" + role + ", status=" + status + "]";
	}
}
