package shoppingbasket;

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingBasketTest {
    
    ShoppingBasket shoppingCart;
   
    // declaring test classes 
    
    public ShoppingBasketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    	
    @Before
    public void setUp() {
          shoppingCart = new ShoppingBasket();  
    }
    
    @After
    public void tearDown()  {
    {
    }        
    }

    // testing item functionality
    @Test
    public void testitem1() {
        
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.777));
        int numberOfItems = shoppingCart.getShoppingItems().size();

        assertThat(numberOfItems, is(1));
    }   
    
    
    // testing item functionality
    @Test
    public void testitem2() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.76));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 5.09));
        int numberOfItems = shoppingCart.getShoppingItems().size();

        assertThat(numberOfItems, is(2));
    }    
    
 // testing item functionality
    @Test
    public void testitem3() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.92));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 4.30));
        shoppingCart.addShoppingItem(new OrderItem("test3", 3, 6.30));
        int numberOfItems = shoppingCart.getShoppingItems().size();

        assertThat(numberOfItems, is(2));
    }    
    
 // testing item functionality
    @Test
    public void testitem4() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.92));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 4.30));
        shoppingCart.addShoppingItem(new OrderItem("test3", 3, 6.30));
        shoppingCart.addShoppingItem(new OrderItem("test4", 3, 7.20));
        int numberOfItems = shoppingCart.getShoppingItems().size();

        assertThat(numberOfItems, is(2));
    }
    
 // testing item functionality
    @Test
    public void testitem5() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.92));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 4.30));
        shoppingCart.addShoppingItem(new OrderItem("test3", 3, 6.30));
        shoppingCart.addShoppingItem(new OrderItem("test4", 3, 7.20));
        shoppingCart.addShoppingItem(new OrderItem("test5", 3, 9.20));
        int numberOfItems = shoppingCart.getShoppingItems().size();

        assertThat(numberOfItems, is(2));
    }
    
    // Testing total functionality
    @Test
    public void testBillInCart() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.32));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 5.87));
        int numberOfItems = shoppingCart.getShoppingItems().size();
        assertThat(numberOfItems, is(2));
        shoppingCart.calcBill();
        double total = shoppingCart.BillTotal();
        assertThat(total, is(19.93));
    }         
    

    // testing clear functionality
    @Test
    public void testClear() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.32));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 5.65));
        shoppingCart.addShoppingItem(new OrderItem("test3", 3, 5.82));        
        shoppingCart.addShoppingItem(new OrderItem("test4", 3, 5.96));        
        int numberOfItems = shoppingCart.getShoppingItems().size();
        assertThat(numberOfItems, is(4));
        shoppingCart.clear();
        numberOfItems = shoppingCart.getShoppingItems().size();
        assertThat(numberOfItems, is(0));
    }

    @Test
    // testing file functionality
    public void testFile() {
        shoppingCart.addShoppingItem(new OrderItem("test", 1, 2.32));
        shoppingCart.addShoppingItem(new OrderItem("test2", 3, 5.65));
        shoppingCart.addShoppingItem(new OrderItem("test3", 3, 5.82));        
        shoppingCart.addShoppingItem(new OrderItem("test4", 3, 5.96));
             
        
    }
    
    
}
