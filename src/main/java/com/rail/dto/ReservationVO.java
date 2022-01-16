package com.rail.dto;

import java.sql.Date;

public class ReservationVO {
	private int reservation_seq,train_seq,quantity,useyn;
	private String id;
	private Date date;
	private String seat;
	public int getReservation_seq() {
		return reservation_seq;
	}
	public void setReservation_seq(int reservation_seq) {
		this.reservation_seq = reservation_seq;
	}
	public int getTrain_seq() {
		return train_seq;
	}
	public void setTrain_seq(int train_seq) {
		this.train_seq = train_seq;
	}
	
	public String getSeat() {
		return seat;
	}
	public void setSeat(String string) {
		this.seat = string;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUseyn() {
		return useyn;
	}
	public void setUseyn(int useyn) {
		this.useyn = useyn;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
