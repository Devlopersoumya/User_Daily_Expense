<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>

<style type="text/css">
  .change{
  color:yellow;
  }
</style>

</head>
<body>
<%Integer id=(Integer)session.getAttribute("userId");
    if(id==null){
    	response.sendRedirect("login.jsp");
    }else{
%>
<%@ include file="components/homenavbare.jsp" %>

<% UserDao dao=new UserDao(); 
   User user=dao.fetchUserById(id);
%>

<h1 style="text-align: center;color:blue">
User name:<p class="change"><%=user.getName() %></p><br>
User age:<p class="change"><%=user.getAge() %></p><br>
User mobile:<p class="change"><%=user.getMobile() %></p><br>
User email:<p class="change"><%=user.getEmail() %></p><br>
</h1>
<%} %>
</body>
</html>