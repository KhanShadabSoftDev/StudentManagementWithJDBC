package com.studentMng;

public class Student {
	private int std_id;
	private String sname;
	private String sphone;
	private String scity;


	public int getStd_id() {
		return std_id;
	}
	public void setStd_id(int std_id) {
		this.std_id = std_id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSphone() {
		return sphone;
	}
	public void setSphone(String sphone) {
		this.sphone = sphone;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}

	public Student(int std_id, String sname, String sphone, String scity) {
		this.std_id = std_id;
		this.sname = sname;
		this.sphone = sphone;
		this.scity = scity;
	}

	public Student(String sname, String sphone, String scity) {
		super();
		this.sname = sname;
		this.sphone = sphone;
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "Student [std_id=" + std_id + ", sname=" + sname + ", sphone=" + sphone + ", scity=" + scity + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
}
