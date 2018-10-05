package com.yjp.springboot.bean;

public class PageInfo {

	private int page;
	private int limt;
	private String sortName;
	private String sort;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimt() {
		return limt;
	}

	public void setLimt(int limt) {
		this.limt = limt;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
