package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Uservalidation extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter k = res.getWriter();
		System.out.println("inside user validation service method");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		 if(username.equals("bharath") && password.equals("123456")){
			k.println("<h1>Welcome to the page</h1>");
			k.println("<h2>You are validated</h2>");
			k.println("<h3>Work Here</h3>");
			k.println("<h3><input type = 'submit' value = 'Logout'/></h3>");
			}
		else
			{
			k.println("<h1>User credentilas not valid</h1>");
			k.println("<h2>Please check the credentials before enter!</h2>");
		}
		
	}

}
