package basket;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ShoppingBasket {
  
    private List<OrderItem> shoppingItems = new ArrayList();
    private double BillTotal;

    public void addShoppingItem(OrderItem shoppingCartItem) {
        shoppingItems.add(shoppingCartItem);
    }

    public List<OrderItem> getShoppingItems() {
        return shoppingItems;
    }

    public void setShoppingItems(List<OrderItem> shoppingItems) {
        this.shoppingItems = shoppingItems;
    }
    
    public double BillTotal() {
        return BillTotal;
    }
    
   // adds up the total method
    public void calcBill() {
        this.BillTotal = 0;
        this.shoppingItems.forEach((item) -> {
            this.BillTotal = (item.getLatestPrice() * item.getQuantity()) + this.BillTotal;
        });
    }

    // Clear basket from array
    public void clear() {
        this.shoppingItems.removeAll(this.shoppingItems);
    }
    
    public void checkout() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");  
    		Connection con=DriverManager.getConnection(  
    		"jdbc:mysql://localhost:3306/assignment","ryan","test");  
    		//here sonoo is database name, root is username and password  
    		PreparedStatement stmt = con.prepareStatement("INSERT into Orders (Book_ref, Book_price, Formats_ordered, Member_id, Download_id) VALUES (?, ?, ?, ?, ?)");
            this.shoppingItems.forEach((item) -> {
            	stmt.setString(1, item.getRef());
            });
            con.close();  
		} catch(Exception e) {
			System.out.println(e);
		}  
    }
}