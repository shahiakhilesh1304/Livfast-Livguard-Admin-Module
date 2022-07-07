package com.livfast.model;

import javax.persistence.*;
import com.livguard.model.Role;
import com.livguard.model.Status;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Entity
@Table(name= "admin_user")
public class LivFastUser 
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
	private Role Role;
	
	@Enumerated(EnumType.STRING)
	private Status Status;	
		
	public LivFastUser()
	{}
	
	public LivFastUser(int id, String name, String empCode, String password, Date entryDate, String email, String msisdn,
			Role Role, Status Status) {
		super();
		this.id = id;
		this.name = name;
		this.empCode = empCode;
		this.password = password;
		this.entryDate = entryDate;
		this.email = email;
		this.msisdn = msisdn;
		this.Role = Role;
		this.Status = Status;
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
		return Role;
	}
	public void setRole(Role Role) {
		this.Role = Role;
	}
	public Status getStatus() {
		return Status;
	}
	public void setStatus(Status Status) {
		this.Status = Status;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", empCode=" + empCode + ", password=" + password + ", entryDate="
				+ entryDate + ", email=" + email + ", msisdn=" + msisdn + ", role=" + Role + ", status=" + Status
				+ "]";
	}
}
