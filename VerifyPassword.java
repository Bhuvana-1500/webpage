import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/VerifyPassword")
public class VerifyPassword extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String pass=req.getParameter("pass");
		UserInformationDao dao=new UserInformationDao();
		HttpSession session=req.getSession();
		String mail=(String)session.getAttribute("email");
		if(dao.verifyEmailAndPassword(mail,pass))
		{
			out.println("<center><h1>valid Password<h1><center>");
		}
		else
		{
			out.println("<center><h1>Invalid password..!!!</h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Password.html");
			dispatcher.include(req,resp);

		}
	}

}
