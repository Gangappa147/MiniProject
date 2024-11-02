package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;


public class ServiceStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String  carRegNumber =	request.getParameter("carRegNumber");
	Car c=new Car();
	c.setCarRegNumber(carRegNumber);
	HttpSession session=request.getSession();
	String username=(String)session.getAttribute("susername");
	c.setUsername(username);
	String service_status=c.serviceStatus();
	session.setAttribute("sstatus", service_status);
	if(service_status ==null) {
		response.sendRedirect("/car-service-system1/serviceStatusFailure.jsp");
	}
	else {
		response.sendRedirect("/car-service-system1/serviceStatusSuccess.jsp");
	}
	}
}
