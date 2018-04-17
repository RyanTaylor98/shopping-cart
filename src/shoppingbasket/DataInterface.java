package shoppingbasket;

import java.sql.*;  

public class DataInterface {
	public void readData(){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/shoppingcart","ryan","test");
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from Books");
		while(rs.next())  
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));  
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
	//TODO: connect to database
	//TODO: read from database
	//TODO: write to database

}
