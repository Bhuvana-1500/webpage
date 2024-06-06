import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserInformationDao 
{
	private String query;
	private Connection connect;
	private ResultSet rs;
	private PreparedStatement ps;
	private String url="jdbc:mysql://localhost:3306?user=root&password=12345";
	public boolean verifyDetails(String date, String name, String dep, String com)
	{
		query="insert into snp.shift values(?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection(url);
			ps=connect.prepareStatement(query);
			ps.setString(1, date);
			ps.setString(2, name);
			ps.setString(3, dep);
			ps.setString(4, com);
			int res=ps.executeUpdate();
			if (res>0)
			{
				return true;
				
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean verifyEmail(String name)
	{
		query="insert into snp.ok values(?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection(url);
			ps=connect.prepareStatement(query);
			ps.setString(1, name);
			rs=ps.executeQuery();
			if (rs.next())
			{
				return true;
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean verifyPassword(String pass)
	{
		query="select * from tejm35.userinformation where password=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection(url);
			ps=connect.prepareStatement(query);
			ps.setString(1, pass);
			rs=ps.executeQuery();
			if (rs.next())
			{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
public boolean verifyEmailAndPassword(String mail,String pass) 
{
	
	String query="select * from tejm35.userinformation where email=? and password=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		connect=DriverManager.getConnection(url);
		ps=connect.prepareStatement(query);
		ps.setString(1,mail);
		ps.setString(2,pass);
		rs=ps.executeQuery();
		if (rs.next())
		{
			return true;
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
	
}
}










