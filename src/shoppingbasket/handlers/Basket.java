package shoppingbasket.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.handler.AbstractHandler;

import shoppingbasket.ShoppingBasket;

public class Basket extends AbstractHandler
{

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException
  {
    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    String id = request.getParameter("memberid"); // Get ID from form on login page
    boolean id_valid = ShoppingBasket.ValidateMember(id);
    File initialFile;
    if (id_valid) { // if id in database then show basket page
      System.out.println("Success");
      initialFile = new File("WebContent/Basket.html");
    } else {
      System.out.println("Failure");
      response.sendRedirect("/?login=fail");
      return;
    }

    InputStream htmlFile = new FileInputStream(initialFile);
    PrintWriter writer = response.getWriter();
    byte[] bytes=new byte[htmlFile.available()];
    htmlFile.read(bytes);
    response.setContentLength(bytes.length);
    writer.print(new String(bytes));
    writer.flush();
    writer.close();
  }
}