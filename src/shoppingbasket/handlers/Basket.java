package shoppingbasket.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.handler.AbstractHandler;

public class Basket extends AbstractHandler
{

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException
  {
    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    String id = request.getHeader("id"); // Get ID from form on login page
    // TODO: get Data interface and check ID

    File initialFile;
    if (false) { // if id in database then show basket page
      initialFile = new File("WebContent/Basket.html");
    } else {
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