<%!

	public int deathPercentage(int s4,int s6){
	int dp=s6*100/s4;
	return dp;

} %>

<%
	
	String sql="SELECT * FROM covidinfo";
 	java.sql.Connection con=mypkg.Utility.connect();
	java.sql.PreparedStatement ps=con.prepareStatement(sql);
	java.sql.ResultSet rs=ps.executeQuery();
	 
	
%>
<html>
<head>
<title>User-Info</title>
</head>
<body>
	<h3>User-Info</h3>	
	<hr>
	<table border="2">
		<tr>
			<th>SNO</th><th>STATE</th><th>DATE</th><th>TOTAL</th><th>ACTIVE</th><th>DEATH</th><th>DEATH%</th>
		</tr>
<% 
		while(rs.next()){
			String s1=rs.getString(1);
			String s2=rs.getString(2);
			String s3=rs.getString(3);
			int s4=rs.getInt(4);
			String s5=rs.getString(5);
			int s6=rs.getInt(6);
			int per=deathPercentage(s4,s6);
		
%>
		<tr>
			<td><%=s1 %></td>
			<td><%=s2 %></td>
			<td><%=s3 %></td>
			<td><%=s4 %></td>
			<td><%=s5 %></td>
			<td><%=s6 %></td>
			<td><%=per+"% " %></td>
			
		</tr>
<%
	}
%>
	</table>
	<hr>	
	<a href="userdashboard.jsp">Dashboard</a>
</body>
</html>

<%
	 con.close();
%>








