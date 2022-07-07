package com.livguard.model.DTOModel;

public class DealerRequest 
{
	private String first_name;
	private String last_name;
	private String address;
	private String area;
	private String city;
	private String district;
	private String postal;
	private String shop_name;
	private String shop_profile;
	private String phone;
	private String dist_code;
	private String dist_name;
	private String email;
	private String state;
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
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
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
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
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * @return the postal
	 */
	public String getPostal() {
		return postal;
	}
	/**
	 * @param postal the postal to set
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}
	/**
	 * @return the shop_name
	 */
	public String getShop_name() {
		return shop_name;
	}
	/**
	 * @param shop_name the shop_name to set
	 */
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	/**
	 * @return the shop_profile
	 */
	public String getShop_profile() {
		return shop_profile;
	}
	/**
	 * @param shop_profile the shop_profile to set
	 */
	public void setShop_profile(String shop_profile) {
		this.shop_profile = shop_profile;
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
	 * @return the dist_code
	 */
	public String getDist_code() {
		return dist_code;
	}
	/**
	 * @param dist_code the dist_code to set
	 */
	public void setDist_code(String dist_code) {
		this.dist_code = dist_code;
	}
	/**
	 * @return the dist_name
	 */
	public String getDist_name() {
		return dist_name;
	}
	/**
	 * @param dist_name the dist_name to set
	 */
	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
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
	@Override
	public String toString() {
		return "DealerRequest [first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", area=" + area + ", city=" + city + ", district=" + district + ", postal=" + postal + ", shop_name="
				+ shop_name + ", shop_profile=" + shop_profile + ", phone=" + phone + ", dist_code=" + dist_code
				+ ", dist_name=" + dist_name + ", email=" + email + ", state=" + state + "]";
	}
	public DealerRequest(String first_name, String last_name, String address, String area, String city, String district,
			String postal, String shop_name, String shop_profile, String phone, String dist_code, String dist_name,
			String email, String state) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.area = area;
		this.city = city;
		this.district = district;
		this.postal = postal;
		this.shop_name = shop_name;
		this.shop_profile = shop_profile;
		this.phone = phone;
		this.dist_code = dist_code;
		this.dist_name = dist_name;
		this.email = email;
		this.state = state;
	}
	public DealerRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
