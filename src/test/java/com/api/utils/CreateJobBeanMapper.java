package com.api.utils;

import java.util.ArrayList;
import java.util.List;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.Customer_address;
import com.api.request.model.Customer_product;
import com.api.request.model.Problems;
import com.dataproviders.api.bean.CreateJobBean;

public class CreateJobBeanMapper {
	//we will giving the bean and it will create the payload for CreateJobAPI
	
	//Util class
	
	//private constructor
	private CreateJobBeanMapper() {
		
	}
	
	public static CreateJobPayload mapper(CreateJobBean bean) {
		//Bean --------CreateJobAPI payload
		
		int mstServiceLocationId=Integer.parseInt(bean.getMst_service_location_id());
		int mstPlatformId=Integer.parseInt(bean.getMst_platform_id());
		int mstWarrentyStatusId=Integer.parseInt(bean.getMst_warrenty_status_id());
		int mstOEMId=Integer.parseInt(bean.getMst_oem_id());
		Customer customer=new Customer(bean.getCustomer_first_name(),
				bean.getCustomer_last_name(), 
				bean.getCustomer_mobile_number(), 
				bean.getCustomer_mobile_number_alt(), 
				bean.getCustomer_email_id(), 
				bean.getCustomer_email_id_alt());
		Customer_address customerAddress=new Customer_address(bean.getCustomer_address_flat_number(), 
				bean.getCustomer_address_apartment_name(), 
				bean.getCustomer_address_street_name(), 
				bean.getCustomer_address_landmark(), 
				bean.getCustomer_address_area(), 
				bean.getCustomer_address_pincode(), 
				bean.getCustomer_address_country(),
				bean.getCustomer_address_state());
		Customer_product customerProduct=new Customer_product(bean.getCustomer_product_dop(), 
				bean.getCustomer_product_serial_number(), 
				bean.getCustomer_product_imei1(), 
				bean.getCustomer_product_imei2(), 
				bean.getCustomer_product_popurl(), 
				Integer.parseInt(bean.getCustomer_product_product_id()),
				Integer.parseInt(bean.getCustomer_product_mst_model_id()) );
		List <Problems> problem=new ArrayList<Problems>();
		Problems problems=new Problems(Integer.parseInt(bean.getProblems_0_id()), bean.getProblems_0_remark());
		problem.add(problems);
		CreateJobPayload payload=new CreateJobPayload(mstServiceLocationId, mstPlatformId, mstWarrentyStatusId, mstOEMId, customer, customerAddress, customerProduct, problem);
		
		return payload;
		
	}

}
