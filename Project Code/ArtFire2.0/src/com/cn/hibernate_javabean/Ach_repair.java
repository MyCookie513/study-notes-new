package com.cn.hibernate_javabean;

import java.sql.Timestamp;

public class Ach_repair {
	

	private int ID;
	private Ach_information ach_information;
	private String alert_id;
	private Timestamp alert_time;	
	private String maintain_status;
	private String alert_infor;
	private String maintain_staff;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Ach_information getAch_information() {
		return ach_information;
	}
	public void setAch_information(Ach_information ach_information) {
		this.ach_information = ach_information;
	}
	public String getAlert_id() {
		return alert_id;
	}
	public void setAlert_id(String alert_id) {
		this.alert_id = alert_id;
	}
	public Timestamp getAlert_time() {
		return alert_time;
	}
	public void setAlert_time(Timestamp alert_time) {
		this.alert_time = alert_time;
	}
	public String getMaintain_status() {
		return maintain_status;
	}
	public void setMaintain_status(String maintain_status) {
		this.maintain_status = maintain_status;
	}
	public String getAlert_infor() {
		return alert_infor;
	}
	public void setAlert_infor(String alert_infor) {
		this.alert_infor = alert_infor;
	}
	public String getMaintain_staff() {
		return maintain_staff;
	}
	public void setMaintain_staff(String maintain_staff) {
		this.maintain_staff = maintain_staff;
	}
	
	
	
	
	
	
	
}
