package com.org.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.org.dao.UserDao;
import com.org.dto.Month;
import com.org.dto.User;
@WebServlet("/changepwd")
public class ChangePwd extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentpwd = req.getParameter("currentpwd");
		String newpwd = req.getParameter("newpwd");
		String conformpwd = req.getParameter("conformpwd");
		
		HttpSession session = req.getSession();
		int id =(Integer) session.getAttribute("userId");
		UserDao dao=new UserDao();
		User user = dao.fetchUserById(id);
		 
		
		
		  if(user.getPassword().equals(currentpwd)) {
			  if(newpwd.equals(conformpwd)) {
				  user.setPassword(conformpwd);
				  dao.savaAndUpdateUser(user);
				  session.setAttribute("changepwd", "Password is changed");
				  resp.sendRedirect("changepwd.jsp");
			  }else {
				  session.setAttribute("changepwd", "New & Conform Password Not Matched");
				  resp.sendRedirect("changepwd.jsp");
			  }
			  
		  }else {
			  session.setAttribute("changepwd", "Invalid Current password");
			  resp.sendRedirect("changepwd.jsp");
		  }
		
	}

}
