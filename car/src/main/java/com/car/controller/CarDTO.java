package com.car.controller;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("serial")
public class CarDTO implements Serializable{
	private String cid, cname, ccate, cdesc;
	private int cprice;
	private MultipartFile file;
	
	public CarDTO() {}

	public CarDTO(String cid, String cname, int cprice, String ccate, String cdesc) {
		this.cid = cid;
		this.cname = cname;
		this.cprice = cprice;
		this.ccate = ccate;
		this.cdesc = cdesc;
	}
	public CarDTO(String cid, String cname, int cprice, String ccate, String cdesc, MultipartFile file) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cprice = cprice;
		this.ccate = ccate;
		this.cdesc = cdesc;
		this.file = file;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCprice() {
		return cprice;
	}

	public void setCprice(int cprice) {
		this.cprice = cprice;
	}

	public String getCcate() {
		return ccate;
	}

	public void setCcate(String ccate) {
		this.ccate = ccate;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	
	
}
