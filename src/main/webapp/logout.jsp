<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%Integer id=(Integer)session.getAttribute("userId");
    if(id==null){
    	response.sendRedirect("login.jsp");
    }else{
%>
   <%@ include file="components/homenavbare.jsp" %>
   
   <h2 style="text-align: center">Are You sure to Logout</h2>
      <p style="text-align: center">
     <a href="logout" class="btn btn-danger decoration-none" >Yes,Logout</a><br>
     <a href="home.jsp" class="btn btn-success decoration-none">No go to Home</a>
      </p>
<%} %>
</body>
</html>