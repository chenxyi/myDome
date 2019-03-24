package com.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.dao.DictDao;
import com.crm.domain.Dict;

@Service
@Transactional
public class DictServiceImpl implements DictService{

	@Autowired
	private DictDao dictDao;
	
	@Override
	public List<Dict> findByCode(String type) {
		return dictDao.findByCode(type);
	}

}
