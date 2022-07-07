package com.livguard.model.DTOModel;


import org.springframework.stereotype.Component;

@Component
public class ScanningAnalysis 
{
	private String name;
	private String email;
	private String imageLink;
	private String phone;
	private String username;
	private int totalTerLoyalty;
	private int totalSecLoyalty;
	
	public ScanningAnalysis() 
	{}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
	 * @return the imageLink
	 */
	public String getImageLink() {
		return imageLink;
	}

	/**
	 * @param imageLink the imageLink to set
	 */
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
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
	 * @return the totalTerLoyalty
	 */
	public int getTotalTerLoyalty() {
		return totalTerLoyalty;
	}

	/**
	 * @param totalTerLoyalty the totalTerLoyalty to set
	 */
	public void setTotalTerLoyalty(int totalTerLoyalty) {
		this.totalTerLoyalty = totalTerLoyalty;
	}

	/**
	 * @return the totalSecLoyalty
	 */
	public int getTotalSecLoyalty() {
		return totalSecLoyalty;
	}

	/**
	 * @param totalSecLoyalty the totalSecLoyalty to set
	 */
	public void setTotalSecLoyalty(int totalSecLoyalty) {
		this.totalSecLoyalty = totalSecLoyalty;
	}

	
	
	public ScanningAnalysis(String name, String email, String imageLink, String phone, String username,
			int totalTerLoyalty, int totalSecLoyalty) {
		this.name = name;
		this.email = email;
		this.imageLink = imageLink;
		this.phone = phone;
		this.username = username;
		this.totalTerLoyalty = totalTerLoyalty;
		this.totalSecLoyalty = totalSecLoyalty;
	}

	@Override
	public String toString() {
		return "ScanningAnalysis [name=" + name + ", email=" + email + ", imageLink=" + imageLink + ", phone=" + phone
				+ ", username=" + username + ", totalTerLoyalty=" + totalTerLoyalty + ", totalSecLoyalty="
				+ totalSecLoyalty + "]";
	}
	
	
	
}
