package com.crm.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.crm.domain.Dict;

@Component
public interface DictDao {
	List<Dict> findByCode(String type);
}
