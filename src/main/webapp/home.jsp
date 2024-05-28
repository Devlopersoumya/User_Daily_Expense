<%@page import="com.org.dto.Expenses"%>
<%@page import="com.org.dto.Month"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp"%>
</head>
<body>
	<%
	Integer id = (Integer) session.getAttribute("userId");
	if (id == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>
	<%@ include file="components/homenavbare.jsp"%>


	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">

					<div class="card-body">
						<p class="fs-3 text-center">Daily Expenses</p>

						<%
						String msg = (String) session.getAttribute("success");
						if (msg != null) {
						%>
						<p class="text-center text-success fs-4"><%=msg%></p>
						<%
						session.removeAttribute("success");
						}
						%>


						<form action="salmonth" method="post">
							Enter Your Salary <input type="tel" name="sal"><br>
							Enter Current Month<input type="text" name="month"> <input
								type="submit" class="btn btn-success ">
						</form>


						<%
						UserDao dao = new UserDao();
						User user = dao.fetchUserById(id);
						List<Month> listOfmonths = user.getMonths();
						for (Month m : listOfmonths) {
						%>

						<h6>
							Month : <b style="color: blue"><%=m.getMonthName()%></b>
						</h6>

						<table class="table">
							<thead>
								<tr>
									<th>Date</th>
									<th>Cause</th>
									<th>Product Name</th>
									<th>Purching Time</th>
									<th>Product Price</th>
									<th>Available Balance</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								double total = m.getSalary();
								for (Expenses e : m.getExpenses()) {
									double avlsal = total;
									avlsal = avlsal - e.getPrice();
								%>


								<tr>
									<td><%=e.getDate()%></td>
									<td><%=e.getCause()%></td>
									<td><%=e.getName()%></td>
									<td><%=e.getTime()%></td>
									<td><%=e.getPrice()%></td>
									<td><%=avlsal%></td>

									<td><a href="delete?id=<%=e.getId()%>"
										class="btn btn-danger decoration-none">Delete</a></td>
								</tr>

								<%
								total = avlsal;
								%>
								<%
								}
								%>
							</tbody>
						</table>
						<p style="text-align: right">
							<a href="add_expenses.jsp?id=<%=m.getId()%>"
								class="text-decoration-none btn btn-primary">Add Expenses</a><br>
							<br>
						</p>
						<%
						}
						%>


					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
	%>
</body>
</html>