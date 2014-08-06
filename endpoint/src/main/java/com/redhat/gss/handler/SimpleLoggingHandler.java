package com.redhat.gss.handler;

import javax.xml.ws.handler.LogicalMessageContext;
import org.jboss.ws.api.handler.GenericSOAPHandler;
import org.jboss.logging.Logger;
import javax.xml.ws.handler.MessageContext;

public abstract class SimpleLoggingHandler extends GenericSOAPHandler<LogicalMessageContext> {
  
  private static Logger log = Logger.getLogger("com.redhat.gss.handlers");

  public boolean handleInbound(MessageContext ctx) {
    log.info("Inbound:  " + getHandlerName());
    return true;
  }

  public boolean handleOutbound(MessageContext ctx) {
    log.info("Outbound: " + getHandlerName());
    return true;
  }
}
