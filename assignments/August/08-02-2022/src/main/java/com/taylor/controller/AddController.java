package com.taylor.controller;

import java.io.IOException;


import com.taylor.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Controller-> Navigates between your model and view
@WebServlet("/add")
public class AddController extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		 String firstName=req.getParameter("firstName");
		 String lastName=req.getParameter("lastName");
		 String username=req.getParameter("username");
		 String password=req.getParameter("password");
		 String address=req.getParameter("address");
		 String contact=req.getParameter("contact");
		 String admin=req.getParameter("isAdmin");
		 boolean isAdmin = false;
		 if(admin == "true")
			 isAdmin = true;
		 
		 
		 
	try {
		Employee u1=new Employee();
		 u1.setEmpFirstName(firstName);
		 u1.setEmpLastName(lastName);
		 u1.setEmpUsername(username);
		 u1.setEmpPassword(password);
		 u1.setEmpAddress(address);
		 u1.setEmpContact(contact);
		 u1.setAdmin(isAdmin);
		 u1.insertEmployee();
		 RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
		 rd.forward(req, res);
		 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
	} 
		 protected void doGet(HttpServletRequest req,HttpServletResponse res)
					throws ServletException,IOException{
			 doPost(req,res);
		 }
	
}
