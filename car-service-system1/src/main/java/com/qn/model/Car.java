package com.qn.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Car {
	private String username;
	private String carmodel;
	private String cartype;
	private String carRegNumber;
	private String servicerequest;
	private String service_status;
	Connection con = null;

	public Car(String username, String carmodel, String cartype, String carRegNumber, String servicerequest,
			String service_status) {
		super();
		this.username = username;
		this.carmodel = carmodel;
		this.cartype = cartype;
		this.carRegNumber = carRegNumber;
		this.servicerequest = servicerequest;
		this.service_status = service_status;
	}

	public Car() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCarmodel() {
		return carmodel;
	}

	public void setCarmodel(String carmodel) {
		this.carmodel = carmodel;
	}

	public String getCartype() {
		return cartype;
	}

	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	public String getCarRegNumber() {
		return carRegNumber;
	}

	public void setCarRegNumber(String carRegNumber) {
		this.carRegNumber = carRegNumber;
	}

	public String getServicerequest() {
		return servicerequest;
	}

	public void setServicerequest(String servicerequest) {
		this.servicerequest = servicerequest;
	}

	public String getService_status() {
		return service_status;
	}

	public void setService_status(String service_status) {
		this.service_status = service_status;
	}

	@Override
	public String toString() {
		return "Car [username=" + username + ", carmodel=" + carmodel + ", cartype=" + cartype + ", carRegNumber="
				+ carRegNumber + ", servicerequest=" + servicerequest + ", service_status=" + service_status + "]";
	}

	{
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_service_system", "root", "Gangappa@123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int carDetails() {
		try {
			String s = "insert into car values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, username);
			pstmt.setString(2, carmodel);
			pstmt.setString(3, cartype);
			pstmt.setString(4, carRegNumber);
			pstmt.setString(5, "NA");
			pstmt.setString(6, "NA");
			int rows = pstmt.executeUpdate();
			return rows;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int serivceRequest() {
		try {
			String s = "update car set servicerequest =?, service_status =? where carRegNumber=?  and username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, servicerequest);
			pstmt.setString(2, "pending");
			pstmt.setString(3, carRegNumber);
			pstmt.setString(4, username);

			int rows = pstmt.executeUpdate();
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public String serviceStatus() {
		try {
			String s = "select * from car where  carRegNumber =? and username=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, carRegNumber);
			pstmt.setString(2, username);
			ResultSet res = pstmt.executeQuery();
			if (res.next()) {
				service_status = res.getString(6);
				return service_status;

			}
		} catch (Exception e) {
			e.printStackTrace();
			

		}
		return null;

	}
	public ArrayList<Car> viewCustomers() {
		try {
			String s="select * from car";
			PreparedStatement pstmt=con.prepareStatement(s);
			ResultSet res=pstmt.executeQuery();
			ArrayList<Car> carDetails=new ArrayList<>();
			while(res.next()) {
				username=res.getString(1);
				carmodel=res.getString(2);
				cartype=res.getString(3);
				carRegNumber=res.getString(4);
				servicerequest=res.getString(5);
				service_status=res.getString(6);
				carDetails.add(new Car(username,carmodel,cartype,carRegNumber,servicerequest,service_status));
				
			}
			return carDetails;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
