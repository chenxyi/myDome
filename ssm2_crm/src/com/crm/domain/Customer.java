package com.crm.domain;

public class Customer {
	private Integer id;
	private String name;
	private String source;
	private String industry;
	private String level;
	private String telephone;
	private String phone;
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", source=" + source + ", industry=" + industry + ", level="
				+ level + ", telephone=" + telephone + ", phone=" + phone + "]";
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
