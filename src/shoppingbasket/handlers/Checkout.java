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

    String order = request.getHeader("order");
    // TODO: write if statement to check order and input to database

    File initialFile = new File("WebContent/Checkout.html");
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