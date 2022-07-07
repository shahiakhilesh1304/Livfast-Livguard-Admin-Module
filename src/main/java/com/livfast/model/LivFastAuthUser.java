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
@Table(name= "auth_user")
public class LivFastAuthUser 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="password")
	private String passsword;
	
	@Column(name="last_login")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	
	@Column(name="is_superuser",insertable = false, updatable = false)
	private Boolean isSuperUser;
	
	@Column(name="username")
	private String username;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="is_staff",insertable = false, updatable = false)
	private Boolean isStaff;
	
	@Column(name="is_active",insertable = false, updatable = false)
	private Boolean isActive;
	
	@Column(name="is_superuser")
	private Date dateJoined;
	

	public LivFastAuthUser() 
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
	 * @return the passsword
	 */
	public String getPasssword() {
		return passsword;
	}

	/**
	 * @param passsword the passsword to set
	 */
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the isSuperUser
	 */
	public Boolean getIsSuperUser() {
		return isSuperUser;
	}

	/**
	 * @param isSuperUser the isSuperUser to set
	 */
	public void setIsSuperUser(Boolean isSuperUser) {
		this.isSuperUser = isSuperUser;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the isStaff
	 */
	public Boolean getIsStaff() {
		return isStaff;
	}

	/**
	 * @param isStaff the isStaff to set
	 */
	public void setIsStaff(Boolean isStaff) {
		this.isStaff = isStaff;
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
	 * @return the dateJoined
	 */
	public Date getDateJoined() {
		return dateJoined;
	}

	/**
	 * @param dateJoined the dateJoined to set
	 */
	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	

	public LivFastAuthUser(int id, String passsword, Date lastLogin, Boolean isSuperUser, String username, String firstName,
			String lastName, String email, Boolean isStaff, Boolean isActive, Date dateJoined) {
		this.id = id;
		this.passsword = passsword;
		this.lastLogin = lastLogin;
		this.isSuperUser = isSuperUser;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isStaff = isStaff;
		this.isActive = isActive;
		this.dateJoined = dateJoined;
	}

	@Override
	public String toString() {
		return "LivFastAuthUser [id=" + id + ", passsword=" + passsword + ", lastLogin=" + lastLogin + ", isSuperUser="
				+ isSuperUser + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", isStaff=" + isStaff + ", isActive=" + isActive + ", dateJoined=" + dateJoined
				+ "]";
	}
}
