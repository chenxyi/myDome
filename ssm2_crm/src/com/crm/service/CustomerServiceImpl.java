package com.crm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.CustomerDao;
import com.crm.domain.Customer;
import com.crm.domain.PageModel;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}

	@Override
	public PageModel<Customer> findByPage(Customer cus, Integer pageNum,int pageSize) {
		PageModel<Customer> pageModel = new PageModel<>();
		
		if(pageNum == null) pageNum = 1;
		int p = 5;	//分页按钮的个数
		Double totalNum = (double) customerDao.findTotal(cus);		//总记录数
		int totalPageNum = (int) Math.ceil(totalNum/pageSize);	//总页数
		
		//1 2 3 4 5 6 7 8 9
		
		//设置开始结束的页码
		if(totalPageNum <= p) {
			pageModel.setStartPage(1);
			pageModel.setEndPage(totalPageNum);
		}else if(pageNum < p/2.0) {
			pageModel.setStartPage(1);
			pageModel.setEndPage(p);
			
		}else if(pageNum > totalPageNum - p/2.0) {
			pageModel.setStartPage(totalPageNum-p+1);
			pageModel.setEndPage(totalPageNum);
		}else {
			pageModel.setStartPage(pageNum-p/2);
			pageModel.setEndPage(pageNum+p/2);
		}
		
		Map<String,Object> map = new HashMap<>();
		map.put("cus", cus);
		map.put("pageNum", (pageNum-1)*pageSize);
		map.put("pageSize", pageSize);
		System.out.println(pageNum);
		List<Customer> list = customerDao.findByPage(map);	
		
		pageModel.setList(list);
		pageModel.setCurrentPageNum(pageNum);
		pageModel.setTotalPageNum(totalPageNum);
		
		return pageModel;
	}

	@Override
	public void delete(Integer id) {
		customerDao.delete(id);
	}

	@Override
	public void update(Customer cus) {
		customerDao.update(cus);
	}

}
