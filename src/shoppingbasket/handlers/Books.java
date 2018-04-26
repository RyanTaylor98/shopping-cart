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

public class Books extends AbstractHandler
{

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException
  {
    response.setContentType("text/json; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    // TODO: get json of books from database
    File initialFile = new File("WebContent/books.json");

    InputStream jsonFile = new FileInputStream(initialFile);
    InputStream jsonDB = ShoppingBasket.GetBooks();
    PrintWriter writer = response.getWriter();
    byte[] bytes=new byte[jsonFile.available()];
    jsonFile.read(bytes);
    response.setContentLength(bytes.length);
    writer.print(new String(bytes));
    writer.flush();
    writer.close();
  }
}