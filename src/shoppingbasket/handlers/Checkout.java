package shoppingbasket.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.handler.AbstractHandler;

public class Checkout extends AbstractHandler
{

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException
  {
    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    String order = request.getHeader("order"); // Get order from from sent on /basket page
    // TODO: write statement to insert order to database
    String orderID = "Response from database";

    File initialFile;
    if (true) { // if order inserted to database and user id correct then
      initialFile = new File("WebContent/Checkout.html");
      response.encodeURL("/checkout?id="+orderID);
    } else { // if
      response.sendRedirect("/?order=fail");
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