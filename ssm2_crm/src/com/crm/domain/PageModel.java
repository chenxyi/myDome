package com.crm.domain;

import java.util.List;

public class PageModel<E> {
	
	private Integer currentPageNum;	//��ǰҳ��
	private Integer pageSize;		//ÿҳ��С
	private Integer totalRecords;	//�ܼ�¼
	private Integer totalPageNum;	//��ҳ��
	private Integer startInedx;		//��ʼ����
	private Integer prePageNum;		//��һҳ
	private Integer nextPageNum;	//��һҳ
	
	private Integer startPage;		//��ʾ��ť�Ŀ�ʼ
	private Integer endPage;		//��ʾ��ť�Ľ���
	private String url;				//·��
	private List<E> list;			//����
	
	
	
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
