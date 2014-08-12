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
import org.jboss.logmanager.LogContext;

@WebService(endpointInterface="com.redhat.gss.ws.HelloWorld")
@Logging(pretty=true)
public class TestService implements HelloWorld {
  private static Logger log = Logger.getLogger(TestService.class);

  public List<String> sayHello(List<String> names) {
    log.info("Invoking endpoint!");
    // org.jboss.logmanager.Logger.getLogger("").setLevel(org.jboss.logmanager.Level.TRACE);
    Object protectionKey = new Object();
    LogContext logCtx = LogContext.getSystemLogContext();
    logCtx.protect(protectionKey);
    logCtx.enableAccess(protectionKey);
    java.util.logging.Logger.getLogger("").setLevel(java.util.logging.Level.FINEST);
    logCtx.disableAccess();
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
