package shoppingbasket;

import java.io.InputStream;
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
    
    public static boolean ValidateMember(String id) {
    	boolean id_check = DataInterface.validateMembers("select * from Members where Member_id="+id);
    	return id_check;
    }
    
   // adds up the total method
    public void calcBill() {
        this.BillTotal = 0;
        this.shoppingItems.forEach((item) -> {
            this.BillTotal = (item.getLatestPrice() * item.getQuantity()) + this.BillTotal;
        });
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

  public static InputStream GetBooks() {
    InputStream jsonData = DataInterface.getBooks("select * from Books;");
    return jsonData;
  }
}