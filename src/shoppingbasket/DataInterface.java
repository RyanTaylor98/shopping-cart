package shoppingbasket;

import java.io.InputStream;
import java.sql.*;

public class DataInterface {
	public static boolean validateMembers(String query){
		try{  
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/shoppingcart","ryan","test");
			//here sonoo is database name, root is username and password
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			if (!rs.next() ) {
					System.out.println("No member in database");
					return false;
			}
			con.close();
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
	}

	public static InputStream getBooks(String query) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/shoppingcart","ryan","test");
			//here sonoo is database name, root is username and password
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			// TODO: convert mysql to input stream
			if (!rs.next() ) {
				System.out.println("No books in database");
				return null;
			}
			con.close();
			return null;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	//TODO: write to database

}
