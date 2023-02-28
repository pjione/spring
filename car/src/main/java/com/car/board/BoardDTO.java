package com.car.board;

public class BoardDTO {
	private String btitle, bcontent, bauthor, bdate;
	
	public BoardDTO() {}
	public BoardDTO(String btitle, String bcontent, String bauthor, String bdate) {
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bauthor = bauthor;
		this.bdate = bdate;
	}
	public String getBtitle() {
		return btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public String getBauthor() {
		return bauthor;
	}

	public String getBdate() {
		return bdate;
	}
	
}
