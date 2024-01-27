

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class StateDataServlet
 */
public class StateDataServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String state=(String)session.getAttribute("state" );
		
		String sql="SELECT * FROM covidinfo WHERE state=?";
		try {
			Connection con=mypkg.Utility.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, state);
			ResultSet rs=ps.executeQuery();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<hr>");
		out.println("<h3>Data for State: "+state+" </h3>");
		out.println("<table  border=2>");
		out.println("<tr>");
		out.println("<th>SNO</th><th>Date</th><th>TOTAL</th><th>ACTIVE</th><th>DEATH</th>");
		out.println("</tr>");
		while(rs.next()) {
			String sno= rs.getString("sno");
			String date =rs.getString("idate");
			String total =rs.getString("total");
			String active =rs.getString("active");
			String deaths =rs.getString("deaths");
			out.println("<tr>");
			out.println("<td>"+sno+"</td>");
			out.println("<td>"+date+"</td>");
			out.println("<td>"+total+"</td>");
			out.println("<td>"+active+"</td>");
			out.println("<td>"+deaths+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<hr>");
		out.println("<h4><a href=stadmindashboard.jsp>Dashboard</a></h4>");

		out.println("</body></html>");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);	
}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);	
	}

}
