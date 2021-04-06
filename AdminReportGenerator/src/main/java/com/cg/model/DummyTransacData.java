package com.cg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DummyTransacData {

	@Id
	private int transId;
	@Column
	private String fromCurr;
	@Column
	private String toCurr;
	@Column
	private String fromUser;
	@Column
	private String toUser;
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public String getFromCurr() {
		return fromCurr;
	}
	public void setFromCurr(String fromCurr) {
		this.fromCurr = fromCurr;
	}
	public String getToCurr() {
		return toCurr;
	}
	public void setToCurr(String toCurr) {
		this.toCurr = toCurr;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public DummyTransacData(int transId, String fromCurr, String toCurr, String fromUser, String toUser) {
		super();
		this.transId = transId;
		this.fromCurr = fromCurr;
		this.toCurr = toCurr;
		this.fromUser = fromUser;
		this.toUser = toUser;
	}
	public DummyTransacData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
