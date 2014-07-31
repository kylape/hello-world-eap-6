package com.redhat.gss.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.ejb.EJB;
import javax.annotation.security.RolesAllowed;

import org.apache.cxf.annotations.EndpointProperties;
import org.apache.cxf.annotations.EndpointProperty;
import org.apache.cxf.annotations.Logging;
import org.apache.cxf.interceptor.InInterceptors;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.EndpointConfig;
import org.jboss.ejb3.annotation.SecurityDomain;

import com.redhat.gss.ejb.SayHi;
import org.jboss.ws.api.annotation.WebContext;

@WebService(endpointInterface="com.redhat.gss.ws.HelloWorld", wsdlLocation="META-INF/wsdl/testService.wsdl")
@Logging(pretty=true)
@EndpointConfig(configFile = "META-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security Endpoint")
@InInterceptors(interceptors = {
  "org.jboss.wsf.stack.cxf.security.authentication.SubjectCreatingPolicyInterceptor"
})
@javax.ejb.Stateless
@SecurityDomain("other")
@WebContext(contextRoot="/hello-world")
@RolesAllowed("hello")
public class TestService implements HelloWorld {
  private static Logger log = Logger.getLogger(TestService.class);
  
  @EJB
  SayHi hi;

  public List<String> sayHello(List<String> names) {
    hi.sayHi(names.get(0));
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
