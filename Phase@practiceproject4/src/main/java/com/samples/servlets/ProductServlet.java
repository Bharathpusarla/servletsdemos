package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.samples.domain.Product;
import com.samples.util.ProductUtil;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Product id;
     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String Pname = request.getParameter("Pname");
		String Pcost = request.getParameter("Pcost");
		String Pcategery= request.getParameter("Pcatogery");
		Product product = new Product(Integer.parseInt(request.getParameter("id")), request.getParameter("Pname"),Integer.parseInt(request.getParameter("Pcost")),request.getParameter("Pcatogery"));
		HttpSession session =request.getSession();
		session.setAttribute("Products", product);
		//response.sendRedirect("/productdisplay.jsp");
	    
		//List ls = new ArrayList();
		//ls.add(product);
		//PrintWriter out = response.getWriter();
		//out.println(ls);
		RequestDispatcher rd = request.getRequestDispatcher("/productdisplay.jsp");
		rd.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher rd = request.getRequestDispatcher("/productdisplay.jsp");
		//rd.forward(request, response);
		
	}

}
