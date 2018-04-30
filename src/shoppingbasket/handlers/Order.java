package shoppingbasket.handlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.handler.AbstractHandler;
import shoppingbasket.ShoppingBasket;

public class Order extends AbstractHandler
{

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException
  {
    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    Enumeration<String> params = request.getParameterNames();
    ArrayList<String> order = new ArrayList<>();
    while(params.hasMoreElements()){
      String paramName = params.nextElement();
      System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
      // TODO: First check for name_integer and add to order array

      // TODO: Second check for matching format_integer

      // TODO: Add to order array
    }

    String orderID = ShoppingBasket.placeOrder(order);

    response.sendRedirect("/checkout?id="+orderID);
  }
}