package shoppingbasket;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.DefaultHandler;
import org.mortbay.jetty.handler.HandlerList;
import org.mortbay.jetty.handler.ResourceHandler;
import shoppingbasket.handlers.Basket;

public class WebServer
{
  public static void main( String[] args ) throws Exception
  {
    Server server = new Server(8080);
    // Create the ResourceHandler. It is the object that will actually handle the request for a given file. It is
    // a Jetty Handler object so it is suitable for chaining with other handlers as you will see in other examples.
    ResourceHandler resource_handler = new ResourceHandler();

    // Configure the ResourceHandler. Setting the resource base indicates where the files should be served out of.
    // In this example it is the current directory but it can be configured to anything that the jvm has access to.
    //resource_handler.setDirectoriesListed(true);
    resource_handler.setWelcomeFiles(new String[]{ "Login.html" });
    resource_handler.setResourceBase("./WebContent");
    String base = resource_handler.getResourceBase();
    System.out.println(base);

    // Add the ResourceHandler to the server.
    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[] { resource_handler, new DefaultHandler() });
    server.setHandler(handlers);

    server.setHandler(new Basket());

    server.start();
    server.join();
  }
}