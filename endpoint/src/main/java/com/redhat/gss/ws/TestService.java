package com.redhat.gss.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.apache.cxf.interceptor.InInterceptors;
import org.jboss.logging.Logger;

@WebService(endpointInterface="com.redhat.gss.ws.HelloWorld")
@InInterceptors(interceptors={"com.redhat.gss.handler.TestCxfInterceptor"})
public class TestService implements HelloWorld {
  private static Logger log = Logger.getLogger(TestService.class);

  public List<String> sayHello(List<String> names) throws Exception {
    List<String> greetings = new ArrayList<String>();
    for(String name : names) {
      greetings.add("Hello, " + name);
    }
    if(log.isDebugEnabled()) {
      for(String greeting : greetings) {
        log.debug(greeting);
      }
    }
    return greetings;
  }
}
