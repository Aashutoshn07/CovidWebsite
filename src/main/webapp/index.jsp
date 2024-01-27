<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WelCome-To-Covid-Infomation-Portal</title>
</head>
<body >
	<h1 style="background-color:Tomato">Covid-Information-Portal</h1>
	<hr>
	<form action="VerifyUser" method="get">
	<table border="0">
		<tr>
		<td style="background-color:lightblue">Email/Uid</td><td> <input type ="text" name="uid"/></td>
		</tr>
		<tr>
		<td>Password  </td><td><input type ="password" name="password"/></td>
		</tr>
		<tr>
		<td>UserType  </td><td><select name ="utype"><option>EndUser</option><option>State-Admin</option><option>Super-Admin</option></select></td>
		</tr>
		<tr>
		<td>Remember-Me  </td><td><input type="checkbox" name="save" value="yes"></td>
		</tr>
		<tr>
				  <td><input type="submit" value="Login"/></td><td><input type="reset"/></td> 	
		</tr>
	</table>
	</form>
	<hr>
	<a href="registration.jsp">New-User-Registration</a><br>
	<a href="helpline.jsp">Helpline-Nos</a>
	
</body>
</html>
<%@ include file="info.jsp"%> 