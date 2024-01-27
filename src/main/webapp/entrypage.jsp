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
<title>Entry-page</title>
</head>
<body>
		<h3>Submit-Info-For-Today</h3>
		<form action="SaveInfo" method="get">
				<pre>
					
					TotalCases		<input type="text" name="total"/>
					ActiveCases		<input type="text" name="active"/>
					TotalDeaths		<input type="text" name="deaths"/>
				
									<input type="submit" value="Submit"/>
				</pre>
		</form>
		<hr>
		<a href="stadmindashboard.jsp">Dashboard</a>
</body>
</html>






