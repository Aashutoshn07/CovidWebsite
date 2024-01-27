

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mypkg.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class SaveInfo
 */
public class SaveInfo extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public void init() {
		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","Ashu@40201");
			con=Utility.connect();
		String sql="INSERT INTO covidinfo(idate,state,total,active,deaths,userid) VALUES(now(),?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void destroy() {
		try {
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException, IOException{
		PrintWriter out=response.getWriter();
		//request-read
//		?state=&userid=&total=&active=&deaths=
		//String userid=request.getParameter("userid");
		//String state =request.getParameter("state");
		
		HttpSession session=request.getSession();
		String userid=(String)session.getAttribute("userid");
		String state=(String)session.getAttribute("state");
		
		int total =Integer.parseInt(request.getParameter("total"));
		int active = Integer.parseInt(request.getParameter("active"));
		int deaths = Integer.parseInt(request.getParameter("deaths"));
		
		//java.util.Date dt=new java.util.Date();
		//long val=dt.getTime();
		//java.sql.Date idate=new java.sql.Date(val);
		
		//process
		try {
			
//			ps.setDate(1, idate); 
			ps.setString(1, state);
			ps.setInt(2,total);
			ps.setInt(3, active);
			ps.setInt(4, deaths);
			ps.setString(5,userid);
			ps.executeUpdate();
			
			out.println("<html><body><h3>Information-Submitted	-Successfully</h3><h4><a href=stadmindashboard.jsp>Dashboard</a></h4></body></html>");
			
		}catch(Exception e) {
			out.println(e);
			System.out.println(e);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);	
	}

}
