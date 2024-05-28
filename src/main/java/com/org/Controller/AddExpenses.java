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

import com.org.dao.MonthDao;
import com.org.dao.UserDao;
import com.org.dto.Expenses;
import com.org.dto.Month;
import com.org.dto.User;
@WebServlet("/addexpense")
public class AddExpenses extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		int monthId=Integer.parseInt(req.getParameter("monthId"));
		
     
	  String date = req.getParameter("date");
	  String cause = req.getParameter("cause");
	  String productName = req.getParameter("proName");
	  String purchingTime = req.getParameter("purTime");
	  long price=Long.parseLong(req.getParameter("price"));
	 
	  HttpSession session = req.getSession();
	  int userId = (Integer)session.getAttribute("userId");
	  
	  UserDao dao=new UserDao();
	  User user = dao.fetchUserById(userId);
	  
	  Expenses expenses=new Expenses();
	  expenses.setDate(date);
	  expenses.setCause(cause);
	  expenses.setName(productName);
	  expenses.setPrice(price);
	  expenses.setTime(purchingTime);
	  
	  List<Expenses>list=new ArrayList<Expenses>();
	  list.add(expenses);
	  
	  MonthDao mdao=new MonthDao();
	  Month month = mdao.FetchMonthById(monthId);
	  
	  month.setExpenses(list);
	  expenses.setMonth(month);
	  
	  List<Month> months = new ArrayList<Month>();
	  months.add(month);
	   
	  
	  
	  user.setMonths(months); 
	  for(Month m:months) {
		  m.setUser(user);
	  }
	  
	
	dao.savaAndUpdateUser(user);
	
	session.setAttribute("success", "Expenses Added");
	resp.sendRedirect("home.jsp");
	
	
	}
	
}
