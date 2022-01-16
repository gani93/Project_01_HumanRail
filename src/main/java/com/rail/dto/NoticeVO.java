package com.rail.dto;

import java.util.Date;

public class NoticeVO {
	private Integer seq;
	private String title;
	private String content;
	private String writer;
	private Date write_date;
	private Integer cnt;

	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	
	
}
