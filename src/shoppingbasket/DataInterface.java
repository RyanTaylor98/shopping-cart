package shoppingbasket;

import java.sql.*;  

public class DataInterface {
	public static void readMembers(String query){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/shoppingcart","ryan","test");
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery(query);
		if (!rs.next() ) {
		    System.out.println("No member in database");
		}   
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
	//TODO: write to database

}
