import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import javax.servlet.annotation.WebServlet;
@WebServlet("/shift")
public class MySrevlet extends GenericServlet {

	private String query;
	private Connection connect;
	private ResultSet rs;
	private PreparedStatement ps;
	private String url="jdbc:sqlserver://serverb.database.windows.net:1433;databaseName=BhuvanaDB;user=tfadmin;password=Bhuvana@15";
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		UserInformationDao dao=new UserInformationDao();
		String date=req.getParameter("date");
		String name=req.getParameter("name");
		String dep=req.getParameter("dep");
		String com=req.getParameter("com");
		String date1=req.getParameter("dates");
		String name1=req.getParameter("names");
	PrintWriter out=res.getWriter();
	res.setContentType("Text/html");
	query="insert into snp values(?,?,?,?)";
	
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connect=DriverManager.getConnection(url);
		ps=connect.prepareStatement(query);
		ps.setString(1, date);
		ps.setString(2, name);
		ps.setString(3, dep);
		ps.setString(4, com);
		int rs1=ps.executeUpdate();
		if (rs1>0)
		{
			out.println("<center><h1 style='color:green;'>Record Added..</h1></center>");
			
		}
	} catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	if (date1!=null && name1!=null)
	{
	query="Select * from snp where date=? and name=?";
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connect=DriverManager.getConnection(url);
		ps=connect.prepareStatement(query);
		ps.setString(1, date1);
		ps.setString(2, name1);
	    rs=ps.executeQuery();
		if (rs.next())
		{
			out.println("<center><h1 style='color:pink;'>Your details based on your date and name:</center></h1>");
			String dt=(rs.getString("date"));
			String nm=(rs.getString("name"));
			String dp=(rs.getString("department"));
			String co=(rs.getString("comments"));
			out.println("<center><h1 style='color:green;'>Date:  "+dt+"</center></h1>");
			out.println("<center><h1 style='color:green;'>Name:  "+nm+"</center></h1>");
			out.println("<center><h1 style='color:green;'>Department:  "+dp+"</center></h1>");
			out.println("<center><h1 style='color:green;'>Comments:  "+co+"</center></h1>");
		}
		else {
			out.println("<center><h1 style='color:red;'>Name Not found on that particular date...</center></h1>");
		}
	} catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
	}
	
