package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crm.domain.Dict;
import com.crm.service.DictService;

@Controller
public class DictController {
	
	@Autowired
	private DictService dictService;
	
	@RequestMapping("/dict/source")
	public @ResponseBody List<Dict> findSource(){
		return dictService.findByCode("source");
		
	}
	
	@RequestMapping("/dict/industry")
	public @ResponseBody List<Dict> findIndustry(){
		return dictService.findByCode("industry");
		
	}
	
	@RequestMapping("/dict/level")
	public @ResponseBody List<Dict> findLevel(){
		return dictService.findByCode("level");
		
	}
	
}
