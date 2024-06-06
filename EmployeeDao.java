import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
	private String url="jdbc:mysql://localhost:3306?user=root&password=12345";
	private String query;
	private Connection connect;
	private ResultSet rs;
	private PreparedStatement ps;
	public boolean verifyByEidEname(int id,String name)
	{
		query="select * from tejm35.employee where eid=? & ename=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=DriverManager.getConnection(url);
			ps=connect.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, name);
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
