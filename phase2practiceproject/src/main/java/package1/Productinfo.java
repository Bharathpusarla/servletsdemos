package package1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productinfo")
public class Productinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			ServletContext context = config.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dburl"),
					context.getInitParameter("dbuser"), context.getInitParameter("dbpassword"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		String productid =request.getParameter("productid");

		PrintWriter out = response.getWriter();
		try (PreparedStatement statement = connection.prepareStatement("select * from products where pid = ?");) {
			statement.setString(1, productid);

			ResultSet results = statement.executeQuery();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>pid</th>");
			out.println("<th>pname</th>");
			out.println("<th>pcost</th>");
			out.println("<th>pcatagery</th>");
			out.println("<th>pwaranty</th>");
			out.println("</tr>");
			while (results.next()) {
				out.println("<tr>");
				out.println("<td>" + results.getInt(1) + "</td>");
				out.println("<td>" + results.getString(2) + "</td>");
				out.println("<td>" + results.getInt(3) + "</td>");
				out.println("<td>" + results.getString(4) + "</td>");
				out.println("<td>" + results.getString(5) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<p><a href=\"Productdetails.html\">back</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void destroy() {
		try {
			System.out.println("Productinfo.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	
	}


