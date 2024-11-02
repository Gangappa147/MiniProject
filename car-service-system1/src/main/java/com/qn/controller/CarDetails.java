package com.qn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;


public class CarDetails extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carmodel=request.getParameter("carmodel");
		String carType=request.getParameter("cartype");
		String carRegNumber=request.getParameter("carRegNumber");
		HttpSession session=request.getSession();
	String username=(String)session.getAttribute("susername");
		
	Car c=new Car();
	c.setUsername(username);
	c.setCarmodel(carmodel);
	c.setCartype(carType);
	c.setCarRegNumber(carRegNumber);
	int rows=c.carDetails();
	if(rows==0) {
		response.sendRedirect("/car-service-system1/cardetailsFailure.jsp");
	}
	else {
		response.sendRedirect("/car-service-system1/cardetailsSuccess.jsp");
	}
		
		
}
}
