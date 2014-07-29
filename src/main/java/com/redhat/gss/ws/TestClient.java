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
    //Create JAX-WS client
    // URL wsdl = new URL("http://localhost:8080/cxf-stax-configure-example/TestService?wsdl");
    URL wsdl = getClass().getResource("/secureService.wsdl");
    QName serviceNS = new QName("http://ws.gss.redhat.com/", "TestServiceService");
    QName portNS = new QName("http://ws.gss.redhat.com/", "TestServicePort");
    Service service = Service.create(wsdl, serviceNS);
    WsIntfc port = service.getPort(portNS, WsIntfc.class);

    Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
    ctx.put("org.apache.cxf.stax.maxChildElements", "10000000");

    try {
      log.info("Generating names...");
      List<String> names = new ArrayList<String>();
      for(int i=0; i<50001; i++) {
        names.add("Kyle");
      }
      log.info("Invoking sayHello with user klape...");
      port.sayHello(names);
      log.debug("Success: Invocation succeeded");
    }
    catch(Exception e) {
      log.error("***FAIL: Invocation did not succed when it should have");
    }
  }
}
