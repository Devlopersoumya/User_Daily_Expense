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
<%Integer userId=(Integer)session.getAttribute("userId");
    if(userId==null){
    	response.sendRedirect("login.jsp");
    }else{
%>
  <%@ include file="components/homenavbare.jsp" %>
  
  <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Expenses Page</p>
						<%int id=Integer.parseInt(request.getParameter("id")); %>
						
						<form action="addexpense" method="post">
							<div class="mb-3">
								<label class="form-label">Date</label> <input name="date"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Cause</label> <input name="cause"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Product Name</label> <input name="proName"
									type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">purching Time</label> <input
									name="purTime" type="text" class="form-control" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Product Price</label> <input
									name="price" type="tel" class="form-control" required>
							</div>
							<input type="hidden" name="monthId" value="<%=id%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">Add</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
  
  <%} %>
</body>
</html>