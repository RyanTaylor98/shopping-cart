package shoppingbasket;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

  public static String GetBooks(String keyName) {
      ResultSet rs = DataInterface.getBooks("select * from Books;");
      Map json = new HashMap();
      List list = new ArrayList();
      if(rs!=null)
      {
        try {
          ResultSetMetaData metaData = rs.getMetaData();
          while(rs.next())
          {
            Map<String,Object> columnMap = new HashMap<String, Object>();
            for(int columnIndex=1;columnIndex<=metaData.getColumnCount();columnIndex++)
            {
              if(rs.getString(metaData.getColumnName(columnIndex))!=null)
                columnMap.put(metaData.getColumnLabel(columnIndex), rs.getString(metaData.getColumnName(columnIndex)));
              else
                columnMap.put(metaData.getColumnLabel(columnIndex), "");
            }
            list.add(columnMap);
          }
          return new Gson().toJson(list);
        } catch (SQLException e) {
          e.printStackTrace();
        }
        json.put(keyName, list);
      }

      return "{}";
  }
}