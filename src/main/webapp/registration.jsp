<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration-Form</h1>
	<hr>
	<form action="RegistrationServlet" method="">
	<table border="0">
		<tr>
			<td>Email/Uid</td><td> <input type ="text" name="uid"/></td>
		</tr>
		<tr>
			<td>Password  </td><td><input type ="password" name="password"/></td>
		</tr>
		<tr>
			<td>Name  </td><td><input type ="text" name="name"/></td>
		</tr>
		<tr>
			<td>Address  </td><td><input type ="text" name="address"/></td>
		</tr>			
		<tr>
			<td>Mobile  </td><td><input type ="text" name="mobile"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register"/></td><td><input type="reset"/></td> 	
		</tr>
	</table>
	</form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>