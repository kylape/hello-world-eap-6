package com.redhat.gss.ws;

import java.net.URL;
import java.util.Map;
import java.util.HashMap;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.jboss.logging.Logger;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import javax.xml.ws.spi.Provider;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestClient {
  private Logger log = Logger.getLogger(this.getClass().getName());

  @Test
  public void testEndpoint() throws Exception {
    URL wsdl        = new URL("http://localhost:8080/hello-world/TestService?wsdl");
    QName serviceNS = new QName("http://ws.gss.redhat.com/", "TestServiceService");
    QName portNS    = new QName("http://ws.gss.redhat.com/", "TestServicePort");

    Service service = Service.create(wsdl, serviceNS);
    HelloWorld port = service.getPort(portNS, HelloWorld.class);

    List<String> argArray = Collections.singletonList("Kyle");
    List<String> returnedArray = port.sayHello(argArray);
    assertEquals("Return value not equal to request arg", argArray.size(), returnedArray.size());
    for(int i=0; i<argArray.size(); i++) {
      assertEquals("Return value not equal to request arg", "Hello, " + argArray.get(i), returnedArray.get(i));
    }
  }

  @Test
  public void testProvider() {
    Provider p = Provider.provider();
    String pName = p.getClass().getName();
    assertEquals("JBossWS is not being used: " + pName, "org.jboss.wsf.stack.cxf.client.ProviderImpl", pName);
  }
}
