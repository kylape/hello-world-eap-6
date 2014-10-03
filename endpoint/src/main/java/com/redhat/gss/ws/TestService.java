package com.redhat.gss.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.annotations.Logging;
import org.apache.cxf.interceptor.InInterceptors;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.jboss.ws.api.annotation.EndpointConfig;

@WebService(endpointInterface="com.redhat.gss.ws.HelloWorld")
// @Logging(pretty=true)
public class TestService implements HelloWorld {
  private static Logger log = LogManager.getLogger(TestService.class);

  public List<String> sayHello(List<String> names) throws Exception {
    List<String> greetings = new ArrayList<String>();
    for(String name : names) {
      greetings.add("Hello, " + name);
    }
    if(log.isWarnEnabled()) {
      for(String greeting : greetings) {
        log.warn(greeting);
      }
    }
    return greetings;
  }
}
