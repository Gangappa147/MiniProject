package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
private String adminusername;
private String adminpassword;
; Connection con;
public Admin(String adminusername, String adminpassword) {
	super();
	this.adminusername = adminusername;
	this.adminpassword = adminpassword;
}
public Admin() {
	super();
}
public String getAdminusername() {
	return adminusername;
}
public void setAdminusername(String adminusername) {
	this.adminusername = adminusername;
}
public String getAdminpassword() {
	return adminpassword;
}
public void setAdminpassword(String adminpassword) {
	this.adminpassword = adminpassword;
}
@Override
public String toString() {
	return "Admin [adminusername=" + adminusername + ", adminpassword=" + adminpassword + "]";
}
{
	try {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system", "root", "Gangappa@123");
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public int adminLogin() {
	try {
		String s="select * from admin where admin_username =?";
		PreparedStatement pstmt=con.prepareStatement(s);
		pstmt.setString(1,adminusername);
		ResultSet res=pstmt.executeQuery();
		if(res.next()) {
			
			if(adminpassword.equals(res.getString(2))) {
				return 1;
				
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
	} catch (Exception e) {
		
	}
	return 0;
}
}