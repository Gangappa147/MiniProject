package com.gm.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DoctorClass {
	private int uid;
     private String uname;
     private String password;
     public String getUid() {
 		return uid;
 	}
 	public void setUname(String uname) {
 		this.uname = uname;
 	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public DoctorClass(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public DoctorClass() {
		super();
	}
	@Override
	public String toString() {
		return "doctor [uname=" + uname + ", password=" + password + "]";
	}
     
	
	public int addResult() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database_db", "root", "Gangappa@123");
			
			String s="insert into ddetails values(?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1,uname);
			pstmt.setString(2,password);
		int rows=pstmt.executeUpdate();
		return rows;
			
			
		} catch (Exception e) {
		  e.printStackTrace();
		}
		return 0;
	}
}
