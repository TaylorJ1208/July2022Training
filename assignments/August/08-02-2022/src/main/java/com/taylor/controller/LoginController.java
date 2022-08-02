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
@WebServlet("/login")
public class LoginController extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException{
		res.setContentType("text/html");
		 String uname=req.getParameter("username");
		 String pwd=req.getParameter("password");
		 
	try {
		Employee u1=new Employee();
		 u1.setEmpUsername(uname);
		 u1.setEmpPassword(pwd);
		boolean status;
			status = u1.validateUserNamePwd();
			
			if(status) {
			 RequestDispatcher rd=req.getRequestDispatcher("success.jsp");
			 rd.forward(req, res);
		
		 }else {
			 RequestDispatcher rd=req.getRequestDispatcher("failure.jsp");
			 rd.forward(req, res);			 
		 }		
			} catch (Exception e) {
			e.printStackTrace();
		}//model
		 
	} 
		 protected void doGet(HttpServletRequest req,HttpServletResponse res)
					throws ServletException,IOException{
			 doPost(req,res);
		 }
	
}
