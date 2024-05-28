package com.org.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.ExpensesDao;

@WebServlet("/delete")
public class DeleteExpenses extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ExpensesDao edao=new ExpensesDao();
		edao.deleteExpensesById(id);
		
		HttpSession session = req.getSession();
		session.setAttribute("success", "Delete Successful");
		resp.sendRedirect("home.jsp");
	}
}
