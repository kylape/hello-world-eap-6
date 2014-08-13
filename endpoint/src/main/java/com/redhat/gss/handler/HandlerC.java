package com.redhat.gss.handler;

import javax.xml.ws.handler.MessageContext;

public class HandlerC extends SimpleLoggingHandler {
  public HandlerC() {
    setHandlerName("C (endpoint)");
  }

  @Override
  public boolean handleInbound(MessageContext ctx) {
    if(true) {
      throw new RuntimeException("I have failed!");
    }
    return false;
  }
}
