package com.database.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.database.DatabaseManager;
import com.dataproviders.api.bean.CreateJobBean;

public class CreateJobPayloadDataDao {

	private static final String SQL_QUERY = 
"""
			SELECT
			tr_job_head.mst_service_location_id,
			tr_job_head.mst_platform_id,
			tr_job_head.mst_warrenty_status_id,
			tr_job_head.mst_oem_id,
			tr_customer.id,
			tr_customer.first_name,
			tr_customer.last_name,
			tr_customer.mobile_number,
			tr_customer.mobile_number_alt,
			tr_customer.email_id,
			tr_customer.email_id_alt,
			tr_customer_address.flat_number,
			tr_customer_address.apartment_name,
			tr_customer_address.street_name,
			tr_customer_address.landmark,
			tr_customer_address.area,
			tr_customer_address.pincode,
			tr_customer_address.country,
			tr_customer_address.state,
			tr_customer_product.id,
			tr_customer_product.tr_customer_id,
			tr_customer_product.mst_model_id,
			tr_customer_product.dop,
			tr_customer_product.popurl,
			tr_customer_product.imei2,
			tr_customer_product.imei1,
			tr_customer_product.serial_number,
			map_job_problem.mst_problem_id,
			map_job_problem.remark

			FROM tr_customer
			INNER JOIN tr_customer_address
			ON  tr_customer_address.id = tr_customer.tr_customer_address_id

			INNER JOIN tr_customer_product
			ON tr_customer_product.tr_customer_id = tr_customer.id

			INNER JOIN tr_job_head
			ON tr_job_head.tr_customer_id = tr_customer.id

			INNER JOIN map_job_problem
			ON tr_job_head.id = map_job_problem.tr_job_head_id

			LIMIT 5

""";
	
	
	public static List<CreateJobBean> getCreateJobPayloadData() {
		//I need the connection so using DatabaseManager Utility
		Connection conn=null;
		Statement statement=null;
		ResultSet result=null;
		List<CreateJobBean> beanList=new ArrayList<>();
		try {
			conn=DatabaseManager.getConnection();
			statement = conn.createStatement();
			result = statement.executeQuery(SQL_QUERY);
			while(result.next()) {
				CreateJobBean bean=new CreateJobBean();
				bean.setMst_service_location_id(result.getString("tr_job_head.mst_service_location_id"));
				bean.setMst_platform_id(result.getString("tr_job_head.mst_platform_id"));
				bean.setMst_warrenty_status_id(result.getString("tr_job_head.mst_warrenty_status_id"));
				bean.setMst_oem_id("1");//bean.setMst_oem_id(result.getString("tr_job_head.mst_oem_id"));
				bean.setCustomer_first_name(result.getString("tr_customer.first_name"));
				bean.setCustomer_last_name(result.getString("tr_customer.last_name"));
				bean.setCustomer_mobile_number(result.getString("tr_customer.mobile_number"));
				bean.setCustomer_mobile_number_alt(result.getString("tr_customer.mobile_number_alt"));
				bean.setCustomer_email_id(result.getString("tr_customer.email_id"));
				bean.setCustomer_email_id_alt(result.getString("tr_customer.email_id_alt"));
				bean.setCustomer_address_flat_number(result.getString("tr_customer_address.flat_number"));
				bean.setCustomer_address_apartment_name(result.getString("tr_customer_address.apartment_name"));
				bean.setCustomer_address_street_name(result.getString("tr_customer_address.street_name"));
				bean.setCustomer_address_landmark(result.getString("tr_customer_address.landmark"));
				bean.setCustomer_address_area(result.getString("tr_customer_address.area"));
				bean.setCustomer_address_pincode(result.getString("tr_customer_address.pincode"));
				bean.setCustomer_address_country(result.getString("tr_customer_address.country"));
				bean.setCustomer_address_state(result.getString("tr_customer_address.state"));
				bean.setCustomer_product_dop(result.getString("tr_customer_product.dop"));
				bean.setCustomer_product_serial_number(result.getString("tr_customer_product.serial_number"));
				bean.setCustomer_product_imei1(result.getString("tr_customer_product.imei1"));
				bean.setCustomer_product_imei2(result.getString("tr_customer_product.imei2"));
				bean.setCustomer_product_popurl(result.getString("tr_customer_product.popurl"));
				bean.setCustomer_product_product_id("1");
				bean.setCustomer_product_mst_model_id("1");//bean.setCustomer_product_mst_model_id(result.getString("tr_customer_product.mst_model_id"));
				bean.setProblems_0_id(result.getString("map_job_problem.mst_problem_id"));
				bean.setProblems_0_remark(result.getString("map_job_problem.remark"));
				beanList.add(bean);
				
				
				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return beanList;
		
	}

}
