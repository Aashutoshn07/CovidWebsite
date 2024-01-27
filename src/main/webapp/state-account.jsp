<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>State-Account-Creation-From</title>
</head>
<body>
		<h1>State-Account-Creation-From</h1>
	<hr>
	<form action="StateAccountCreationServlet" method="get">
	<table border="0">
		<tr>
			<td>Userid</td><td> <input type ="text" name="uid"/></td>
		</tr>
		<tr>
			<td>Password  </td><td><input type ="password" name="password"/></td>
		</tr>
		<tr>
			<td>State  </td><td><select type ="state">
						<option>AP</option>
						<option>MP</option>
						<option>MH</option>
						<option>RJ</option>
						<option>UT</option>
						<option>HY</option>
			</select></td>
		</tr>
		<tr>
			<td><input type="submit" value="Create-Account"/></td><td><input type="reset"/></td> 	
		</tr>
	</table>
	</form>
	<hr>
	<a href="index.jsp">Home</a>
</body>
</html>