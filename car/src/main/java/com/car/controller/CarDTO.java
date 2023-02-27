package com.car.controller;

public class CarDTO {
	private String cid, cname, cprice, ccate, cdesc;
	
	public CarDTO() {}

	public CarDTO(String cid, String cname, String cprice, String ccate, String cdesc) {
		this.cid = cid;
		this.cname = cname;
		this.cprice = cprice;
		this.ccate = ccate;
		this.cdesc = cdesc;
	}

	public String getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public String getCprice() {
		return cprice;
	}

	public String getCcate() {
		return ccate;
	}

	public String getCdesc() {
		return cdesc;
	}
	
	
}
