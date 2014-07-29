package com.redhat.gss.ws;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.annotations.Logging;
import org.jboss.ws.api.annotation.EndpointConfig;
import org.jboss.logging.Logger;
import java.util.List;
import java.util.ArrayList;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.annotations.EndpointProperties;

@javax.jws.WebService
// @Logging(pretty=true)
@EndpointProperties({
  @EndpointProperty(key="org.apache.cxf.stax.maxTextLength", value="10000000"),
  @EndpointProperty(key="org.apache.cxf.stax.maxChildElements", value="10000000")
})
public class TestService {
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
