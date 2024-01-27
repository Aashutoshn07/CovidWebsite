

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

//@WebServlet(urlPatterns = {"/All"})
public class AllDataServlet extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		
		
		String sql="SELECT * FROM covidinfo";
		try {
			Connection con=mypkg.Utility.connect();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("<hr>");
		out.println("<h3>Data for State All States </h3>");
		out.println("<table  border=2>");
		out.println("<tr>");
		out.println("<th>SNO</th><th>STATE</th><th>DATE</th><th>TOTAL</th><th>ACTIVE</th><th>DEATH</th>");
		out.println("</tr>");
		int sumTotalCases=0;
		int sumActiveCases=0;
		int sumDeaths=0; 
		while(rs.next()) {
			String sno= rs.getString("sno");
			String state=rs.getString("state");
			String date =rs.getString("idate");
			int total =rs.getInt("total");
			sumTotalCases+=total;
			int active =rs.getInt("active");
			sumActiveCases+=active;
			int deaths =rs.getInt("deaths");
			sumDeaths+=deaths;
			out.println("<tr>");
			out.println("<td>"+sno+"</td>");
			out.println("<td>"+state+"</td>");

			out.println("<td align= right>"+date+"</td>");
			out.println("<td align= right>"+total+"</td>");
			out.println("<td align= right>"+active+"</td>");
			out.println("<td align= right>"+deaths+"</td>");
			out.println("</tr>");
		}
		out.println("<tr>");
		out.println("<td></td><td></td><td></td><td align= right>"+sumTotalCases+"</td><td align= right>"+sumActiveCases+"</td><td align= right>"+sumDeaths+"</td>");
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
