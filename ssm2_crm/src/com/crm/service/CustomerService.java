package com.crm.service;

import java.util.List;

import com.crm.domain.Customer;
import com.crm.domain.PageModel;

public interface CustomerService {
	List<Customer> findAll();

	PageModel<Customer> findByPage(Customer cus, Integer pageNum ,int pageSize);
	
	void delete(Integer id);
	
	void update(Customer cus);
}
