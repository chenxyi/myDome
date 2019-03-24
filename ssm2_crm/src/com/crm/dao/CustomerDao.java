package com.crm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.crm.domain.Customer;

@Component
public interface CustomerDao {
	List<Customer> findAll();

	int findTotal(Customer cus);

	List<Customer> findByPage(Map<String,Object> map);
	
	void delete(Integer id);
	
	void update(Customer cus);
}
