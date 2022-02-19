package com.iu.s1.notice;

import java.sql.Date;

public class NoticeDTO {

	private Long num;	
	private String title;
	private String contents;
	private String wrier;
	private Date regdate;
	private Long hit;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWrier() {
		return wrier;
	}
	public void setWrier(String wrier) {
		this.wrier = wrier;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Long getHit() {
		return hit;
	}
	public void setHit(Long hit) {
		this.hit = hit;
	}
	
	
}
