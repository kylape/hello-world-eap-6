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
import javax.jws.HandlerChain;

@WebService(endpointInterface="com.redhat.gss.ws.HelloWorld")
@EndpointConfig(configName="Custom Handlers", configFile="WEB-INF/jaxws-endpoint-config.xml")
@Logging(pretty=true)
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
