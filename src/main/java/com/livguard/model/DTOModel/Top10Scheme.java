package com.livguard.model.DTOModel;

import org.springframework.stereotype.Component;

@Component
public class Top10Scheme 
{
	private String userID;
	private String name;
	private String email;
	private String salesPersonName;
	private String phone;
	private String username;
	private int totalLoyalty;
	/**
	 * 
	 */
	public Top10Scheme() {}
	

	
	/**
	 * @param userID
	 * @param name
	 * @param email
	 * @param salesPersonName
	 * @param phone
	 * @param username
	 * @param totalLoyalty
	 */
	public Top10Scheme(String userID, String name, String email, String salesPersonName, String phone, String username,
			int totalLoyalty) {
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.salesPersonName = salesPersonName;
		this.phone = phone;
		this.username = username;
		this.totalLoyalty = totalLoyalty;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the salesPersonName
	 */
	public String getSalesPersonName() {
		return salesPersonName;
	}
	/**
	 * @param salesPersonName the salesPersonName to set
	 */
	public void setSalesPersonName(String salesPersonName) {
		this.salesPersonName = salesPersonName;
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
	
	
	@Override
	public String toString() {
		return "Top10Scheme [userID=" + userID + ", name=" + name + ", email=" + email + ", salesPersonName="
				+ salesPersonName + ", phone=" + phone + ", username=" + username + ", totalLoyalty=" + totalLoyalty
				+ "]";
	}
	
}
