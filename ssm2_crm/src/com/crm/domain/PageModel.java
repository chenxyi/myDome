package com.crm.domain;

import java.util.List;

public class PageModel<E> {
	
	private Integer currentPageNum;	//当前页码
	private Integer pageSize;		//每页大小
	private Integer totalRecords;	//总记录
	private Integer totalPageNum;	//总页数
	private Integer startInedx;		//开始索引
	private Integer prePageNum;		//上一页
	private Integer nextPageNum;	//下一页
	
	private Integer startPage;		//显示按钮的开始
	private Integer endPage;		//显示按钮的结束
	private String url;				//路径
	private List<E> list;			//数据
	
	
	
	@Override
	public String toString() {
		return "PageModel [currentPageNum=" + currentPageNum + ", pageSize=" + pageSize + ", totalRecords="
				+ totalRecords + ", totalPageum=" + totalPageNum + ", startInedx=" + startInedx + ", prePageNum="
				+ prePageNum + ", nextPageNum=" + nextPageNum + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", url=" + url + "]";
	}
	
	public Integer getCurrentPageNum() {
		return currentPageNum;
	}
	public void setCurrentPageNum(Integer currentPageNum) {
		this.currentPageNum = currentPageNum;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public Integer getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(Integer totalPageum) {
		this.totalPageNum = totalPageum;
	}
	public Integer getStartInedx() {
		return startInedx;
	}
	public void setStartInedx(Integer startInedx) {
		this.startInedx = startInedx;
	}
	public Integer getPrePageNum() {
		return prePageNum;
	}
	public void setPrePageNum(Integer prePageNum) {
		this.prePageNum = prePageNum;
	}
	public Integer getNextPageNum() {
		return nextPageNum;
	}
	public void setNextPageNum(Integer nextPageNum) {
		this.nextPageNum = nextPageNum;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	
}
