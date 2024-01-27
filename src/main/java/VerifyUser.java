

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mypkg.Utility;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class VerifyUser extends HttpServlet {

	private Connection con;
	private PreparedStatement ps1, ps2;
	
	@Override
	public void init() {
		try {
			con=Utility.connect();	
			ps1=con.prepareStatement("SELECT * FROM users WHERE email=? AND password=?");
			ps2=con.prepareStatement("SELECT * FROM stateadmins WHERE userid=? AND password=?");
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
				String id=request.getParameter("uid");
				String pw=request.getParameter("password");
				String utype=request.getParameter("utype");
				System.out.println("Your last Log-in was: ");
				
				if(utype.equals("Super-Admin")) {
					if(id.equals("sadmin")&& pw.equals("ssi")) {
//						response.sendRedirect("sadmindashboard.jsp");
						RequestDispatcher rd=request.getRequestDispatcher("sadmindashboard.jsp");
						rd.forward(request, response);
					}else {
						out.println("<html><body><h3>");
						out.println("Invalid Super Admin Account!</h3>");
						out.println("<h4><a href=index.jsp>Try-Again</a></h4>");
						out.println("</body></html>");
						
					}
				}else if(utype.equals("State-Admin")) {
					try {
						ps2.setString(1, id);
						ps2.setString(2, pw);
						ResultSet rs=ps2.executeQuery();
						boolean found=rs.next();
						
						if(found) {
							String status =rs.getString("status");
							String uid=rs.getString("userid");
							if(status.equals("disabled")) {
								out.println("<html>");
								out.println("<body>");
								out.println("<h3>Profile-Complition-Form-Show</h3>");
								out.println("<form action=UpdateStateAdminProfile>");
								out.println("<pre>");
								out.println("Userid			: <input type=text name=uid value="+uid+">");
								out.println("Password		: <input type=password name=password>");
								out.println("Username		: <input type=text name=uname>");
								out.println("Address		: <input type=text name=address>");
								out.println("Email			: <input type=text name=email>");
								out.println("Mobile			: <input type=text name=mobile>");
								
								out.println("<input type=submit name=Update>");
								out.println("</pre>");
								
								out.println("</form>");
								out.println("</body>");
								out.println("</html>");
								
							}else {
								HttpSession session=request.getSession();
								session.setAttribute("userid",id);
								session.setAttribute("state", rs.getString("state"));
								response.sendRedirect("stadmindashboard.jsp");
							}
						
						}else {
							out.println("<html><body><h3>");
							out.println("Invalid State-Admin Account!</h3>");
							out.println("<h4><a href=index.jsp>Try-Again</a></h4>");
							out.println("</body></html>");
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else {
					try {
						ps1.setString(1,id);
						ps1.setString(2,pw);
						ResultSet rs=ps1.executeQuery();
						boolean found=rs.next();
						if(found) {
							response.sendRedirect("userdashboard.jsp");
						}else {
							out.println("<html><body><h3>");
							out.println("Invalid User Account!</h3>");
							out.println("<h4><a href=index.jsp>Try-Again</a></h4>");
							out.println("</body></html>");						}
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				

			}
			
			protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				processRequest(request, response);
			}

			protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				processRequest(request, response);
				
			}
}
