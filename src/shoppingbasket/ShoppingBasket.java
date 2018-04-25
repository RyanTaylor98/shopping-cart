package shoppingbasket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ShoppingBasket {
  
    private List<OrderItem> shoppingItems = new ArrayList();
    private double BillTotal;

    public void addShoppingItem(OrderItem shoppingCartItem) {
        shoppingItems.add(shoppingCartItem);
    }

    public List<OrderItem> getShoppingItems() {
        return shoppingItems;
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
              try {
                stmt.setString(1, item.getRef());
              } catch (SQLException e) {
                e.printStackTrace();
              }
            });
            con.close();
      } catch(Exception e) {
        System.out.println(e);
      }
    }
}