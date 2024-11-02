package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Admin;


public class AdminLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminusername=request.getParameter("adminusername");
		String adminpassword=request.getParameter("adminpassword");
		
		Admin a =new Admin();
		a.setAdminusername(adminusername);
		a.setAdminpassword(adminpassword);
		
		int status=a.adminLogin();
		if(status==1) {
			
			response.sendRedirect("/car-service-system1/adminloginSuccess.jsp");
		}
		else if(status==-1) {
			response.sendRedirect("/car-service-system1/invalidAdminusername.jsp");
		}
		else {
			response.sendRedirect("/car-service-system1/invalidAdminpassword.jsp");
		}
	}


}
