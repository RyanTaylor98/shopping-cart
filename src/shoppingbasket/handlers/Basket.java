package shoppingbasket.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mortbay.jetty.HttpConnection;
import org.mortbay.jetty.Request;
import org.mortbay.jetty.handler.AbstractHandler;

public class Login extends AbstractHandler
{
  final String greeting;
  final String body;

  public Login()
  {
    this("Hello World");
  }

  public Login( String greeting )
  {
    this(greeting, null);
  }

  public Login( String greeting, String body )
  {
    this.greeting = greeting;
    this.body = body;
  }

  @Override
  public void handle( String target,
      HttpServletRequest request,
      HttpServletResponse response, int i ) throws IOException,
      ServletException
  {
    response.setContentType("text/html; charset=utf-8");
    response.setStatus(HttpServletResponse.SC_OK);

    PrintWriter out = response.getWriter();

    out.println("<h1>" + greeting + "</h1>");
    if (body != null)
    {
      out.println(body);
    }
    Request base_request = (request instanceof Request) ? (Request) request
        : HttpConnection.getCurrentConnection().getRequest();
    base_request.setHandled(true);
  }
}