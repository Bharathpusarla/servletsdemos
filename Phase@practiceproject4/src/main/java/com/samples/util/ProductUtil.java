package com.samples.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.samples.domain.Product;
import com.samples.servlets.ProductServlet;

public class ProductUtil {
		
		public List<Product> getProductss() {
			List<Product> products = new ArrayList<>();
			
			ProductServlet ps = new ProductServlet();
			products.add(ps.id);
			
			
			return products;
			
		

	}
}
