package com.qn.controller;

import java.io.IOException;
  
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qn.model.Car;


public class ServiceRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String serviceRequest=	request.getParameter("servicerequest");
  String carRegNumber=	request.getParameter("carRegNumber");
  
  HttpSession session=request.getSession();
  Car c=new Car();
  String username=(String)session.getAttribute("susername");
  c.setUsername(username);
  c.setServicerequest(serviceRequest);
  c.setCarRegNumber(carRegNumber);
 

  
  int status=c.serivceRequest();
  if(status==0) {
	  response.sendRedirect("/car-service-system1/serviceRequestFailure.jsp");
	  
  }
  else {
	  response.sendRedirect("/car-service-system1/serviceRequestSuccess.jsp");
  }
	}

}
