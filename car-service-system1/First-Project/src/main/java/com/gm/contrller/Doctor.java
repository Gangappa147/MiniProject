package com.gm.contrller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gm.model.DoctorClass;


public class Doctor extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int uid=Integer.parseInt("uid");
		String uname=request.getParameter("uname");
	String password=request.getParameter("password");
	
	DoctorClass tempDoctor=new DoctorClass();
	tempDoctor.setUid(uid);
	tempDoctor.setUname(uname);
	tempDoctor.setPassword(password);
	
	int rows=tempDoctor.addResult();
	if(rows==1) {
		response.sendRedirect("/First-Project/addResultSuccess.html");
	}
	else {
		response.sendRedirect("/First-Project/addResultFailure.html");
	}
	}

}
