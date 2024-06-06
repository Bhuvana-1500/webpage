import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class new1 {

	public void enter(String name)
	{
		
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="insert into snp.ok values(?)";
		try 
		{
			System.out.println("hello");
			//Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect=DriverManager.getConnection(url);
			PreparedStatement ps=connect.prepareStatement(query);
			ps.setString(1, name);
			System.out.println("OK");
			int rs=ps.executeUpdate();
			if (rs>0)
			{
				System.out.println(rs+" record updated...!!!!!");
			}
			else
			{
				System.out.println("record inserted...!!!!");
			}
			connect.close();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		} 
		
	}
}

