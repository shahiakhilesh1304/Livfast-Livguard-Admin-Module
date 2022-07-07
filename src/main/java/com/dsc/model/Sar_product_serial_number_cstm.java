//package com.dsc.model;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//
//@Component
//@Entity
//@Table(name= "sar_product_serial_number_cstm")
//public class Sar_product_serial_number_cstm
//{
//	@Id
//	private String id_c;
//	
//	private String sap_code_c;
//	private String aos_products_id_c;
//	private String contact_id_c;
//	private String account_code_c;
//	private String account_name_c;
//	private String primary_sale_date_c;
//	private String invoice_number_c;
//	private String bf_chr_c4_c;
//	private String battery_type_c;
//	private String bf_chr_c5_c;
//	private String bf_chr_c6_c;
//	private String aft_chr_c3_c;
//	private String bf_chr_c2_c;
//	private String aft_chr_c4_c;
//	private String aft_chr_c2_c;
//	private String battery_ah_c;
//	private String aft_chr_c1_c;
//	private String bf_chr_c1_c;
//	private String bf_chr_c3_c;
//	private String aft_chr_c5_c;
//	private String aft_chr_c6_c;
//	private String manufacturing_date_c;
//	private String dealer_code_c;
//	private String dealer_name_c;
//	private String aging_c;
//	/**
//	 * @return the id_c
//	 */
//	public String getId_c() {
//		return id_c;
//	}
//	/**
//	 * @param id_c the id_c to set
//	 */
//	public void setId_c(String id_c) {
//		this.id_c = id_c;
//	}
//	/**
//	 * @return the sap_code_c
//	 */
//	public String getSap_code_c() {
//		return sap_code_c;
//	}
//	/**
//	 * @param sap_code_c the sap_code_c to set
//	 */
//	public void setSap_code_c(String sap_code_c) {
//		this.sap_code_c = sap_code_c;
//	}
//	/**
//	 * @return the aos_products_id_c
//	 */
//	public String getAos_products_id_c() {
//		return aos_products_id_c;
//	}
//	/**
//	 * @param aos_products_id_c the aos_products_id_c to set
//	 */
//	public void setAos_products_id_c(String aos_products_id_c) {
//		this.aos_products_id_c = aos_products_id_c;
//	}
//	/**
//	 * @return the contact_id_c
//	 */
//	public String getContact_id_c() {
//		return contact_id_c;
//	}
//	/**
//	 * @param contact_id_c the contact_id_c to set
//	 */
//	public void setContact_id_c(String contact_id_c) {
//		this.contact_id_c = contact_id_c;
//	}
//	/**
//	 * @return the account_code_c
//	 */
//	public String getAccount_code_c() {
//		return account_code_c;
//	}
//	/**
//	 * @param account_code_c the account_code_c to set
//	 */
//	public void setAccount_code_c(String account_code_c) {
//		this.account_code_c = account_code_c;
//	}
//	/**
//	 * @return the account_name_c
//	 */
//	public String getAccount_name_c() {
//		return account_name_c;
//	}
//	/**
//	 * @param account_name_c the account_name_c to set
//	 */
//	public void setAccount_name_c(String account_name_c) {
//		this.account_name_c = account_name_c;
//	}
//	/**
//	 * @return the primary_sale_date_c
//	 */
//	public String getPrimary_sale_date_c() {
//		return primary_sale_date_c;
//	}
//	/**
//	 * @param primary_sale_date_c the primary_sale_date_c to set
//	 */
//	public void setPrimary_sale_date_c(String primary_sale_date_c) {
//		this.primary_sale_date_c = primary_sale_date_c;
//	}
//	/**
//	 * @return the invoice_number_c
//	 */
//	public String getInvoice_number_c() {
//		return invoice_number_c;
//	}
//	/**
//	 * @param invoice_number_c the invoice_number_c to set
//	 */
//	public void setInvoice_number_c(String invoice_number_c) {
//		this.invoice_number_c = invoice_number_c;
//	}
//	/**
//	 * @return the bf_chr_c4_c
//	 */
//	public String getBf_chr_c4_c() {
//		return bf_chr_c4_c;
//	}
//	/**
//	 * @param bf_chr_c4_c the bf_chr_c4_c to set
//	 */
//	public void setBf_chr_c4_c(String bf_chr_c4_c) {
//		this.bf_chr_c4_c = bf_chr_c4_c;
//	}
//	/**
//	 * @return the battery_type_c
//	 */
//	public String getBattery_type_c() {
//		return battery_type_c;
//	}
//	/**
//	 * @param battery_type_c the battery_type_c to set
//	 */
//	public void setBattery_type_c(String battery_type_c) {
//		this.battery_type_c = battery_type_c;
//	}
//	/**
//	 * @return the bf_chr_c5_c
//	 */
//	public String getBf_chr_c5_c() {
//		return bf_chr_c5_c;
//	}
//	/**
//	 * @param bf_chr_c5_c the bf_chr_c5_c to set
//	 */
//	public void setBf_chr_c5_c(String bf_chr_c5_c) {
//		this.bf_chr_c5_c = bf_chr_c5_c;
//	}
//	/**
//	 * @return the bf_chr_c6_c
//	 */
//	public String getBf_chr_c6_c() {
//		return bf_chr_c6_c;
//	}
//	/**
//	 * @param bf_chr_c6_c the bf_chr_c6_c to set
//	 */
//	public void setBf_chr_c6_c(String bf_chr_c6_c) {
//		this.bf_chr_c6_c = bf_chr_c6_c;
//	}
//	/**
//	 * @return the aft_chr_c3_c
//	 */
//	public String getAft_chr_c3_c() {
//		return aft_chr_c3_c;
//	}
//	/**
//	 * @param aft_chr_c3_c the aft_chr_c3_c to set
//	 */
//	public void setAft_chr_c3_c(String aft_chr_c3_c) {
//		this.aft_chr_c3_c = aft_chr_c3_c;
//	}
//	/**
//	 * @return the bf_chr_c2_c
//	 */
//	public String getBf_chr_c2_c() {
//		return bf_chr_c2_c;
//	}
//	/**
//	 * @param bf_chr_c2_c the bf_chr_c2_c to set
//	 */
//	public void setBf_chr_c2_c(String bf_chr_c2_c) {
//		this.bf_chr_c2_c = bf_chr_c2_c;
//	}
//	/**
//	 * @return the aft_chr_c4_c
//	 */
//	public String getAft_chr_c4_c() {
//		return aft_chr_c4_c;
//	}
//	/**
//	 * @param aft_chr_c4_c the aft_chr_c4_c to set
//	 */
//	public void setAft_chr_c4_c(String aft_chr_c4_c) {
//		this.aft_chr_c4_c = aft_chr_c4_c;
//	}
//	/**
//	 * @return the aft_chr_c2_c
//	 */
//	public String getAft_chr_c2_c() {
//		return aft_chr_c2_c;
//	}
//	/**
//	 * @param aft_chr_c2_c the aft_chr_c2_c to set
//	 */
//	public void setAft_chr_c2_c(String aft_chr_c2_c) {
//		this.aft_chr_c2_c = aft_chr_c2_c;
//	}
//	/**
//	 * @return the battery_ah_c
//	 */
//	public String getBattery_ah_c() {
//		return battery_ah_c;
//	}
//	/**
//	 * @param battery_ah_c the battery_ah_c to set
//	 */
//	public void setBattery_ah_c(String battery_ah_c) {
//		this.battery_ah_c = battery_ah_c;
//	}
//	/**
//	 * @return the aft_chr_c1_c
//	 */
//	public String getAft_chr_c1_c() {
//		return aft_chr_c1_c;
//	}
//	/**
//	 * @param aft_chr_c1_c the aft_chr_c1_c to set
//	 */
//	public void setAft_chr_c1_c(String aft_chr_c1_c) {
//		this.aft_chr_c1_c = aft_chr_c1_c;
//	}
//	/**
//	 * @return the bf_chr_c1_c
//	 */
//	public String getBf_chr_c1_c() {
//		return bf_chr_c1_c;
//	}
//	/**
//	 * @param bf_chr_c1_c the bf_chr_c1_c to set
//	 */
//	public void setBf_chr_c1_c(String bf_chr_c1_c) {
//		this.bf_chr_c1_c = bf_chr_c1_c;
//	}
//	/**
//	 * @return the bf_chr_c3_c
//	 */
//	public String getBf_chr_c3_c() {
//		return bf_chr_c3_c;
//	}
//	/**
//	 * @param bf_chr_c3_c the bf_chr_c3_c to set
//	 */
//	public void setBf_chr_c3_c(String bf_chr_c3_c) {
//		this.bf_chr_c3_c = bf_chr_c3_c;
//	}
//	/**
//	 * @return the aft_chr_c5_c
//	 */
//	public String getAft_chr_c5_c() {
//		return aft_chr_c5_c;
//	}
//	/**
//	 * @param aft_chr_c5_c the aft_chr_c5_c to set
//	 */
//	public void setAft_chr_c5_c(String aft_chr_c5_c) {
//		this.aft_chr_c5_c = aft_chr_c5_c;
//	}
//	/**
//	 * @return the aft_chr_c6_c
//	 */
//	public String getAft_chr_c6_c() {
//		return aft_chr_c6_c;
//	}
//	/**
//	 * @param aft_chr_c6_c the aft_chr_c6_c to set
//	 */
//	public void setAft_chr_c6_c(String aft_chr_c6_c) {
//		this.aft_chr_c6_c = aft_chr_c6_c;
//	}
//	/**
//	 * @return the manufacturing_date_c
//	 */
//	public String getManufacturing_date_c() {
//		return manufacturing_date_c;
//	}
//	/**
//	 * @param manufacturing_date_c the manufacturing_date_c to set
//	 */
//	public void setManufacturing_date_c(String manufacturing_date_c) {
//		this.manufacturing_date_c = manufacturing_date_c;
//	}
//	/**
//	 * @return the dealer_code_c
//	 */
//	public String getDealer_code_c() {
//		return dealer_code_c;
//	}
//	/**
//	 * @param dealer_code_c the dealer_code_c to set
//	 */
//	public void setDealer_code_c(String dealer_code_c) {
//		this.dealer_code_c = dealer_code_c;
//	}
//	/**
//	 * @return the dealer_name_c
//	 */
//	public String getDealer_name_c() {
//		return dealer_name_c;
//	}
//	/**
//	 * @param dealer_name_c the dealer_name_c to set
//	 */
//	public void setDealer_name_c(String dealer_name_c) {
//		this.dealer_name_c = dealer_name_c;
//	}
//	/**
//	 * @return the aging_c
//	 */
//	public String getAging_c() {
//		return aging_c;
//	}
//	/**
//	 * @param aging_c the aging_c to set
//	 */
//	public void setAging_c(String aging_c) {
//		this.aging_c = aging_c;
//	}
//	@Override
//	public String toString() {
//		return "Sar_product_serial_number_cstm [id_c=" + id_c + ", sap_code_c=" + sap_code_c + ", aos_products_id_c="
//				+ aos_products_id_c + ", contact_id_c=" + contact_id_c + ", account_code_c=" + account_code_c
//				+ ", account_name_c=" + account_name_c + ", primary_sale_date_c=" + primary_sale_date_c
//				+ ", invoice_number_c=" + invoice_number_c + ", bf_chr_c4_c=" + bf_chr_c4_c + ", battery_type_c="
//				+ battery_type_c + ", bf_chr_c5_c=" + bf_chr_c5_c + ", bf_chr_c6_c=" + bf_chr_c6_c + ", aft_chr_c3_c="
//				+ aft_chr_c3_c + ", bf_chr_c2_c=" + bf_chr_c2_c + ", aft_chr_c4_c=" + aft_chr_c4_c + ", aft_chr_c2_c="
//				+ aft_chr_c2_c + ", battery_ah_c=" + battery_ah_c + ", aft_chr_c1_c=" + aft_chr_c1_c + ", bf_chr_c1_c="
//				+ bf_chr_c1_c + ", bf_chr_c3_c=" + bf_chr_c3_c + ", aft_chr_c5_c=" + aft_chr_c5_c + ", aft_chr_c6_c="
//				+ aft_chr_c6_c + ", manufacturing_date_c=" + manufacturing_date_c + ", dealer_code_c=" + dealer_code_c
//				+ ", dealer_name_c=" + dealer_name_c + ", aging_c=" + aging_c + "]";
//	}
//	public Sar_product_serial_number_cstm(String id_c, String sap_code_c, String aos_products_id_c, String contact_id_c,
//			String account_code_c, String account_name_c, String primary_sale_date_c, String invoice_number_c,
//			String bf_chr_c4_c, String battery_type_c, String bf_chr_c5_c, String bf_chr_c6_c, String aft_chr_c3_c,
//			String bf_chr_c2_c, String aft_chr_c4_c, String aft_chr_c2_c, String battery_ah_c, String aft_chr_c1_c,
//			String bf_chr_c1_c, String bf_chr_c3_c, String aft_chr_c5_c, String aft_chr_c6_c,
//			String manufacturing_date_c, String dealer_code_c, String dealer_name_c, String aging_c) {
//		this.id_c = id_c;
//		this.sap_code_c = sap_code_c;
//		this.aos_products_id_c = aos_products_id_c;
//		this.contact_id_c = contact_id_c;
//		this.account_code_c = account_code_c;
//		this.account_name_c = account_name_c;
//		this.primary_sale_date_c = primary_sale_date_c;
//		this.invoice_number_c = invoice_number_c;
//		this.bf_chr_c4_c = bf_chr_c4_c;
//		this.battery_type_c = battery_type_c;
//		this.bf_chr_c5_c = bf_chr_c5_c;
//		this.bf_chr_c6_c = bf_chr_c6_c;
//		this.aft_chr_c3_c = aft_chr_c3_c;
//		this.bf_chr_c2_c = bf_chr_c2_c;
//		this.aft_chr_c4_c = aft_chr_c4_c;
//		this.aft_chr_c2_c = aft_chr_c2_c;
//		this.battery_ah_c = battery_ah_c;
//		this.aft_chr_c1_c = aft_chr_c1_c;
//		this.bf_chr_c1_c = bf_chr_c1_c;
//		this.bf_chr_c3_c = bf_chr_c3_c;
//		this.aft_chr_c5_c = aft_chr_c5_c;
//		this.aft_chr_c6_c = aft_chr_c6_c;
//		this.manufacturing_date_c = manufacturing_date_c;
//		this.dealer_code_c = dealer_code_c;
//		this.dealer_name_c = dealer_name_c;
//		this.aging_c = aging_c;
//	}
//	public Sar_product_serial_number_cstm() {
//		// TODO Auto-generated constructor stub
//	}
//
//}