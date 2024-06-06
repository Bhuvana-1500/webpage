import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/VerifyEmail")
public class VerifyEmail extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String email=req.getParameter("mail");
		UserInformationDao dao=new UserInformationDao();
		HttpSession session=req.getSession();
		session.setAttribute("email", email);
		if (dao.verifyEmail(email))
		{
			out.println("<center><h1>Valid Email id..!!!</h1></center");
		RequestDispatcher dispatcher=req.getRequestDispatcher("Password.html");
		dispatcher.forward(req,resp);
		}
		else
		{
			out.println("<center><h1>Invalid Email Id..!!!</h1></center>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Email.html");
			dispatcher.include(req,resp);

		}
	}

}
