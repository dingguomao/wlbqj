package com.entity;

public class Page {

	private int page;//当前页码
	private int pageSize;//页面大小
	private int totality;//数据总数
	private int pages;//总页数
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotality() {
		return totality;
	}
	public void setTotality(int totality) {
		this.totality = totality;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public Page(int page, int pageSize, int totality, int pages) {
		super();
		this.page = page;
		this.pageSize = pageSize;
		this.totality = totality;
		this.pages = pages;
	}
	
	
	

}
