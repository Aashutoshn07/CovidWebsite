

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypkg.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class RegistrationServlet extends HttpServlet {
	private Connection con;
	private PreparedStatement ps;
	@Override
	public void init() {
		try {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coviddata","root","Ashu@40201");
			con=Utility.connect();
		String sql="INSERT INTO users VALUES (?,?,?,?,?)";
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
		//uid=aaa%40gmail.com&password=aaa&name=aaa&address=indore&mobile=9926075423
		String userid=request.getParameter("uid");
		String password =request.getParameter("password");
		String name =request.getParameter("name");
		String address = request.getParameter("address");
		String mobile = request.getParameter("mobile");
		
		//process
		try {
			
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, address);
			ps.setString(5, mobile); 
			ps.executeUpdate();
			
			out.println("<html><body><h3>Register-Successfully</h3><h4><a href=index.jsp>Login-Now</a></h4></body></html>");
			
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
