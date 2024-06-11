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
@WebServlet("/New")
public class New extends GenericServlet{
	private String query;
	private Connection connect;
	private ResultSet rs;
	private PreparedStatement ps;
	private String url="jdbc:sqlserver://serverb.database.windows.net:1433;databaseName=BhuvanaDB;user=tfadmin;password=Bhuvana@15";
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	PrintWriter out=res.getWriter();
	res.setContentType("Text/html");
	query="insert into snp values(?,?,?,?)";
	out.println("done");
	
}
}
