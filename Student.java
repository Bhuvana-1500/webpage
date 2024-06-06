import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Student")
public class Student extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int eid=Integer.parseInt(req.getParameter("id"));
		String ename=req.getParameter("name");
		PrintWriter out=res.getWriter();
		EmployeeDao dao=new EmployeeDao();
		if (dao.verifyByEidEname(eid,ename))
		{
			out.println("<center><h1>Login Succesfull..!!!</h1></center");
		}
		else
		{
			out.println("<center><h1>Invalid Credentials..!!!</h1></center");
		}
		
	}

}
