package shoppingbasket.handlers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.handler.AbstractHandler;
import shoppingbasket.ShoppingBasket;

public class Books extends AbstractHandler
{

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException
  {
    response.setContentType("text/json; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    File initialFile = new File("WebContent/books.json");

    String books = ShoppingBasket.GetBooks("books");
    InputStream jsonFile = new ByteArrayInputStream(books.getBytes(StandardCharsets.UTF_8));
    PrintWriter writer = response.getWriter();
    byte[] bytes=new byte[jsonFile.available()];
    jsonFile.read(bytes);
    response.setContentLength(bytes.length);
    writer.print(new String(bytes));
    writer.flush();
    writer.close();
  }
}