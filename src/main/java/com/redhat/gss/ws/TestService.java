package com.redhat.gss.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.annotations.Logging;
import org.apache.cxf.interceptor.InInterceptors;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService(endpointInterface="com.redhat.gss.ws.HelloWorld")
// @Logging(pretty=true)
@EndpointProperties({
  @EndpointProperty(key="org.apache.cxf.stax.maxTextLength", value="10000000"),
  @EndpointProperty(key="org.apache.cxf.stax.maxChildElements", value="10000000")
})
public class TestService implements HelloWorld {
  private static Logger log = Logger.getLogger(TestService.class);

  public List<String> sayHello(List<String> names) {
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
