package shoppingbasket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataInterface {

	private static String connectionString = "jdbc:mysql://localhost:3306/shoppingcart"
	private static String dbUser = "ryan";
	private static String dbPassword = "test";
	private static String dbString = "com.mysql.jdbc.Driver";

	public static boolean validateMembers(String query){
		try{  
			Class.forName(dbString);
			Connection con=DriverManager.getConnection(
			connectionString, dbUser, dbPassword);
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

	public static ResultSet getBooks(String query) {
		try{
			Class.forName(dbString);
			Connection con=DriverManager.getConnection(
					connectionString, dbUser, dbPassword);
			//here sonoo is database name, root is username and password
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	public static ResultSet checkOrder(String query) {
		try{
			Class.forName(dbString);
			Connection con=DriverManager.getConnection(
					connectionString, dbUser, dbPassword);
			//here sonoo is database name, root is username and password
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}

	public static ResultSet finaliseOrder(String query) {
		query = "INSERT INTO Orders (Book_ref, Book_price, Formats_ordered, Member_id, Download_id) VALUES (\"F001\", 3.99, \"EPUB\", 1154, \"123e4567-e89b-12d3-a456-556642440000\")";
		try{
			Class.forName(dbString);
			Connection con=DriverManager.getConnection(
					connectionString, dbUser, dbPassword);
			//here sonoo is database name, root is username and password
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		}catch(Exception e){
			System.out.println(e);
			return null;
		}
	}


}
