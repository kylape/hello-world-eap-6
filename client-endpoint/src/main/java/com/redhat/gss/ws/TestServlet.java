package com.redhat.gss.ws;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.jboss.logging.Logger;
import java.io.OutputStream;

@WebServlet({"/client"})
public class TestServlet extends HttpServlet {
  private static Logger log = Logger.getLogger(TestServlet.class);

  @Override
  public void init() {
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    URL wsdl        = new URL("http://localhost:8080/hello-world/TestService?wsdl");
    QName serviceNS = new QName("http://ws.gss.redhat.com/", "TestServiceService");
    QName portNS    = new QName("http://ws.gss.redhat.com/", "TestServicePort");

    Service service = Service.create(wsdl, serviceNS);
    HelloWorld port = service.getPort(portNS, HelloWorld.class);

    List<String> argArray = Collections.singletonList("Kyle");
    long startTime = System.nanoTime();
    List<String> returnedArray = port.sayHello(argArray);
    long endTime = System.nanoTime();
    log.infof("Invocation time elapsed: %dms", ((endTime - startTime) / 1000000));
    log.info("Returned name: " + returnedArray.get(0));
    String result = "Success!";
    if(!returnedArray.get(0).equals("Hello, Kyle")) {
      result = "Downstream endpoint not functioning properly!";
    } 

    byte[] bb = (result + "\n").getBytes();
    OutputStream os = response.getOutputStream();
    os.write(bb);
    os.close();
  }
}
