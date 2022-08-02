package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
        //updateDB();
        DeleteintoDB();
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","1234");
				Statement st = con.createStatement();) {
			ResultSet rs = st.executeQuery("Select * from account");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getInt(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

	private static void updateDB() {
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","1234");
				Statement st = con.createStatement();) {
			int rowsupdated = st.executeUpdate("update account set balance=2005 where accno = 1");
			System.out.println("Number of rows inserted"+rowsupdated);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	private static void InsertintoDB() {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","1234");
				Statement st = con.createStatement();) {
			int rowsinserted = st.executeUpdate("insert into account values(4,'surya','pusarla',10000)");
			System.out.println("Number of rows inserted"+rowsinserted);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		private static void DeleteintoDB() {
			try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","1234");
					Statement st = con.createStatement();) {
				int rowsdeleted = st.executeUpdate("Delete accout where balance = 10000");
				System.out.println("Number of rows deleted"+rowsdeleted);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
	
