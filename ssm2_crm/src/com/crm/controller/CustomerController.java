package com.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.domain.Customer;
import com.crm.domain.PageModel;
import com.crm.service.CustomerService;

@Controller
public class CustomerController {
	
	private int pageSize = 8;
	private int a = 4;
	
	@Autowired
	private CustomerService customerServiec;
	
	@RequestMapping(value = "/customer/list")
	public String list(Model model,Integer pageNum,Customer cus){

		PageModel<Customer> pageModel = customerServiec.findByPage(cus,pageNum,pageSize);
		
		model.addAttribute("pageModel", pageModel);
		model.addAttribute("cus", cus);
		return "customer";
	}
	
	@RequestMapping(value="customer/delete")
	public @ResponseBody String delete(Integer id) {
		customerServiec.delete(id);		
		//"redirect:/customer/list.action"
		return "ok";
	}
	
	@RequestMapping(value="customer/edit")
	public @ResponseBody String edit(Customer cus) {
		customerServiec.update(cus);	
		return "ok";
	}
	
	
}
