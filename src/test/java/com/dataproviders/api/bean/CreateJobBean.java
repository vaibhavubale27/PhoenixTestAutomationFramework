package com.dataproviders.api.bean;

import com.opencsv.bean.CsvBindByName;
import com.poiji.annotation.ExcelCellName;

public class CreateJobBean {
	
	@ExcelCellName("mst_service_location_id")
	@CsvBindByName(column = "mst_service_location_id")
	private String mst_service_location_id;
	
	@ExcelCellName("mst_platform_id")
	@CsvBindByName(column = "mst_platform_id")
	private String mst_platform_id;
	
	@ExcelCellName("mst_warrenty_status_id")
	@CsvBindByName(column = "mst_warrenty_status_id")
	private String mst_warrenty_status_id;
	
	@ExcelCellName("mst_oem_id")
	@CsvBindByName(column = "mst_oem_id")
	private String mst_oem_id;
	
	@ExcelCellName("customer_first_name")
	@CsvBindByName(column = "customer_first_name")
	private String customer_first_name;
	
	@ExcelCellName("customer_last_name")
	@CsvBindByName(column = "customer_last_name")
	private String customer_last_name;
	
	@ExcelCellName("customer_mobile_number")
	@CsvBindByName(column = "customer_mobile_number")
	private String customer_mobile_number;
	
	@ExcelCellName("customer_mobile_number_alt")
	@CsvBindByName(column = "customer_mobile_number_alt")
	private String customer_mobile_number_alt;
	
	@ExcelCellName("customer_email_id")
	@CsvBindByName(column = "customer_email_id")
	private String customer_email_id;
	
	@ExcelCellName("customer_email_id_alt")
	@CsvBindByName(column = "customer_email_id_alt")
	private String customer_email_id_alt;
	
	@ExcelCellName("customer_address_flat_number")
	@CsvBindByName(column = "customer_address_flat_number")
	private String customer_address_flat_number;
	
	@ExcelCellName("customer_address_apartment_name")
	@CsvBindByName(column = "customer_address_apartment_name")
	private String customer_address_apartment_name;
	
	@ExcelCellName("customer_address_street_name")
	@CsvBindByName(column = "customer_address_street_name")
	private String customer_address_street_name;
	
	@ExcelCellName("customer_address_landmark")
	@CsvBindByName(column = "customer_address_landmark")
	private String customer_address_landmark;
	
	@ExcelCellName("customer_address_area")
	@CsvBindByName(column = "customer_address_area")
	private String customer_address_area;
	
	@ExcelCellName("customer_address_pincode")
	@CsvBindByName(column = "customer_address_pincode")
	private String customer_address_pincode;
	
	@ExcelCellName("customer_address_country")
	@CsvBindByName(column = "customer_address_country")
	private String customer_address_country;
	
	@ExcelCellName("customer_address_state")
	@CsvBindByName(column = "customer_address_state")
	private String customer_address_state;
	
	@ExcelCellName("customer_product_dop")
	@CsvBindByName(column = "customer_product_dop")
	private String customer_product_dop;
	
	@ExcelCellName("customer_product_serial_number")
	@CsvBindByName(column = "customer_product_serial_number")
	private String customer_product_serial_number;
	
	@ExcelCellName("customer_product_imei1")
	@CsvBindByName(column = "customer_product_imei1")
	private String customer_product_imei1;
	
	@ExcelCellName("customer_product_imei2")
	@CsvBindByName(column = "customer_product_imei2")
	private String customer_product_imei2;
	
	@ExcelCellName("customer_product_popurl")
	@CsvBindByName(column = "customer_product_popurl")
	private String customer_product_popurl;
	
	@ExcelCellName("customer_product_product_id")
	@CsvBindByName(column = "customer_product_product_id")
	private String customer_product_product_id;
	
	@ExcelCellName("customer_product_mst_model_id")
	@CsvBindByName(column = "customer_product_mst_model_id")
	private String customer_product_mst_model_id;
	
	@ExcelCellName("problems_0_id")
	@CsvBindByName(column = "problems_0_id")
	private String problems_0_id;
	
	@ExcelCellName("problems_0_remark")
	@CsvBindByName(column = "problems_0_remark")
	private String problems_0_remark;
	

	public CreateJobBean() {

	}

	public String getMst_service_location_id() {
		return mst_service_location_id;
	}

	public void setMst_service_location_id(String mst_service_location_id) {
		this.mst_service_location_id = mst_service_location_id;
	}

	public String getMst_platform_id() {
		return mst_platform_id;
	}

	public void setMst_platform_id(String mst_platform_id) {
		this.mst_platform_id = mst_platform_id;
	}

	public String getMst_warrenty_status_id() {
		return mst_warrenty_status_id;
	}

	public void setMst_warrenty_status_id(String mst_warrenty_status_id) {
		this.mst_warrenty_status_id = mst_warrenty_status_id;
	}

	public String getMst_oem_id() {
		return mst_oem_id;
	}

	public void setMst_oem_id(String mst_oem_id) {
		this.mst_oem_id = mst_oem_id;
	}

	public String getCustomer_first_name() {
		return customer_first_name;
	}

	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public String getCustomer_mobile_number() {
		return customer_mobile_number;
	}

	public void setCustomer_mobile_number(String customer_mobile_number) {
		this.customer_mobile_number = customer_mobile_number;
	}

	public String getCustomer_mobile_number_alt() {
		return customer_mobile_number_alt;
	}

	public void setCustomer_mobile_number_alt(String customer_mobile_number_alt) {
		this.customer_mobile_number_alt = customer_mobile_number_alt;
	}

	public String getCustomer_email_id() {
		return customer_email_id;
	}

	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}

	public String getCustomer_email_id_alt() {
		return customer_email_id_alt;
	}

	public void setCustomer_email_id_alt(String customer_email_id_alt) {
		this.customer_email_id_alt = customer_email_id_alt;
	}

	public String getCustomer_address_flat_number() {
		return customer_address_flat_number;
	}

	public void setCustomer_address_flat_number(String customer_address_flat_number) {
		this.customer_address_flat_number = customer_address_flat_number;
	}

	public String getCustomer_address_apartment_name() {
		return customer_address_apartment_name;
	}

	public void setCustomer_address_apartment_name(String customer_address_apartment_name) {
		this.customer_address_apartment_name = customer_address_apartment_name;
	}

	public String getCustomer_address_street_name() {
		return customer_address_street_name;
	}

	public void setCustomer_address_street_name(String customer_address_street_name) {
		this.customer_address_street_name = customer_address_street_name;
	}

	public String getCustomer_address_landmark() {
		return customer_address_landmark;
	}

	public void setCustomer_address_landmark(String customer_address_landmark) {
		this.customer_address_landmark = customer_address_landmark;
	}

	public String getCustomer_address_area() {
		return customer_address_area;
	}

	public void setCustomer_address_area(String customer_address_area) {
		this.customer_address_area = customer_address_area;
	}

	public String getCustomer_address_pincode() {
		return customer_address_pincode;
	}

	public void setCustomer_address_pincode(String customer_address_pincode) {
		this.customer_address_pincode = customer_address_pincode;
	}

	public String getCustomer_address_country() {
		return customer_address_country;
	}

	public void setCustomer_address_country(String customer_address_country) {
		this.customer_address_country = customer_address_country;
	}

	public String getCustomer_address_state() {
		return customer_address_state;
	}

	public void setCustomer_address_state(String customer_address_state) {
		this.customer_address_state = customer_address_state;
	}

	public String getCustomer_product_dop() {
		return customer_product_dop;
	}

	public void setCustomer_product_dop(String customer_product_dop) {
		this.customer_product_dop = customer_product_dop;
	}

	public String getCustomer_product_serial_number() {
		return customer_product_serial_number;
	}

	public void setCustomer_product_serial_number(String customer_product_serial_number) {
		this.customer_product_serial_number = customer_product_serial_number;
	}

	public String getCustomer_product_imei1() {
		return customer_product_imei1;
	}

	public void setCustomer_product_imei1(String customer_product_imei1) {
		this.customer_product_imei1 = customer_product_imei1;
	}

	public String getCustomer_product_imei2() {
		return customer_product_imei2;
	}

	public void setCustomer_product_imei2(String customer_product_imei2) {
		this.customer_product_imei2 = customer_product_imei2;
	}

	public String getCustomer_product_popurl() {
		return customer_product_popurl;
	}

	public void setCustomer_product_popurl(String customer_product_popurl) {
		this.customer_product_popurl = customer_product_popurl;
	}

	public String getCustomer_product_product_id() {
		return customer_product_product_id;
	}

	public void setCustomer_product_product_id(String customer_product_product_id) {
		this.customer_product_product_id = customer_product_product_id;
	}

	public String getCustomer_product_mst_model_id() {
		return customer_product_mst_model_id;
	}

	public void setCustomer_product_mst_model_id(String customer_product_mst_model_id) {
		this.customer_product_mst_model_id = customer_product_mst_model_id;
	}

	public String getProblems_0_id() {
		return problems_0_id;
	}

	public void setProblems_0_id(String problems_0_id) {
		this.problems_0_id = problems_0_id;
	}

	public String getProblems_0_remark() {
		return problems_0_remark;
	}

	public void setProblems_0_remark(String problems_0_remark) {
		this.problems_0_remark = problems_0_remark;
	}

	@Override
	public String toString() {
		return "CreateJobBean [mst_service_location_id=" + mst_service_location_id + ", mst_platform_id="
				+ mst_platform_id + ", mst_warrenty_status_id=" + mst_warrenty_status_id + ", mst_oem_id=" + mst_oem_id
				+ ", customer_first_name=" + customer_first_name + ", customer_last_name=" + customer_last_name
				+ ", customer_mobile_number=" + customer_mobile_number + ", customer_mobile_number_alt="
				+ customer_mobile_number_alt + ", customer_email_id=" + customer_email_id + ", customer_email_id_alt="
				+ customer_email_id_alt + ", customer_address_flat_number=" + customer_address_flat_number
				+ ", customer_address_apartment_name=" + customer_address_apartment_name
				+ ", customer_address_street_name=" + customer_address_street_name + ", customer_address_landmark="
				+ customer_address_landmark + ", customer_address_area=" + customer_address_area
				+ ", customer_address_pincode=" + customer_address_pincode + ", customer_address_country="
				+ customer_address_country + ", customer_address_state=" + customer_address_state
				+ ", customer_product_dop=" + customer_product_dop + ", customer_product_serial_number="
				+ customer_product_serial_number + ", customer_product_imei1=" + customer_product_imei1
				+ ", customer_product_imei2=" + customer_product_imei2 + ", customer_product_popurl="
				+ customer_product_popurl + ", customer_product_product_id=" + customer_product_product_id
				+ ", customer_product_mst_model_id=" + customer_product_mst_model_id + ", problems_0_id="
				+ problems_0_id + ", problems_0_remark=" + problems_0_remark + "]";
	}

}
