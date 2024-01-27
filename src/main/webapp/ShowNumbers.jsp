
<%
	String state= request.getParameter("t1");
	String contact="";
	switch (state){
	case "mp":
		contact="04343232";
		break;
	case "mh":
		contact="0874532";
		break;
	case "rj":
		contact="0996832";
		break;
	default :
		contact="123456";
	}
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>Helpline Number for Your State:<%=state %> </h3>
		Numbers:  <%=contact %>
</body>
</html>