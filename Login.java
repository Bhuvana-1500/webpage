import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Backend output
		//System.out.println("Login Succesfully");
		//set the type of content
		resp.setContentType("text/html");
		//to print the output on web browser
		PrintWriter out=resp.getWriter();
		//text
		//out.println("Login Successfully.....!!!!");
		//html
		out.print("<center><h1 style='color:pink;background-color:violet;'>Login Successfully........!!!!</h1> </center>");
	}

}
