package com.taylor.controller;

import java.io.IOException;

import com.taylor.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Controller-> Navigates between your model and view
@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		 String id = req.getParameter("deleteId");
		 
	try {
		Employee u1=new Employee();
		 u1.setId(Integer.parseInt(id));
		 u1.deleteEmployee();
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
