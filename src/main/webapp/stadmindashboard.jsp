
<%
		String userid=(String)session.getAttribute("userid");
		if(userid==null){
			response.sendRedirect("index.jsp");
		}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>State-Admin-Dashboard</title>
</head>
<body>
		<h3>State-Admin-Dashboard</h3>
		<hr>
		<pre>
		<a href="entrypage.jsp">Add-Info-For-Today</a>
		<a href="">Update-Info</a>
		<a href="StateDataServlet">View-Info-For-Own-State</a>
		<a href="AllDataServlet">View-Info-For-All-State</a>
		<a href="EndSession">Logout</a>
		</pre>
		<hr>
		
</body>
</html>