package com.org.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Month;
import com.org.dto.User;
@WebServlet("/salmonth")
public class SalAndMonth extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	long salary=Long.parseLong(req.getParameter("sal"));
	String monthName=req.getParameter("month");
	
	HttpSession session = req.getSession();
	int id =(Integer) session.getAttribute("userId");
	
	UserDao dao=new UserDao();
	User user = dao.fetchUserById(id);
	
	 Month month=new Month();
	 month.setMonthName(monthName);
	 month.setSalary(salary);
	 
	 List<Month>list=new ArrayList<Month>();
	 list.add(month);
	 
	 user.setMonths(list);
	 month.setUser(user);
	 
	dao.savaAndUpdateUser(user);
	
	resp.sendRedirect("home.jsp");
	 
}
}
