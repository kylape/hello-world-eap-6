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

public class TestClient {
  private Logger log = Logger.getLogger(this.getClass().getName());

  public static void main(String[] args) throws Exception {
    TestClient client = new TestClient();
    client.invoke();
  }

  public void invoke() throws Exception {
    URL wsdl        = new URL("http://localhost:8080/hello-world/TestService?wsdl");
    QName serviceNS = new QName("http://ws.gss.redhat.com/", "TestServiceService");
    QName portNS    = new QName("http://ws.gss.redhat.com/", "TestServicePort");

    Service service = Service.create(wsdl, serviceNS);
    HelloWorld port = service.getPort(portNS, HelloWorld.class);

    try {
      log.info("Invoking sayHello with user klape...");
      port.sayHello(Collections.singletonList("Kyle"));
      log.debug("Success: Invocation succeeded");
    }
    catch(Exception e) {
      log.error("***FAIL: Invocation did not succed when it should have");
    }
  }
}
