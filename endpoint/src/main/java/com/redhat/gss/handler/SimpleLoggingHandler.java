package com.redhat.gss.handler;

import javax.xml.ws.handler.LogicalMessageContext;
import org.jboss.ws.api.handler.GenericSOAPHandler;
import org.jboss.logging.Logger;
import javax.xml.ws.handler.MessageContext;
import javax.xml.transform.Source;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPHeaderElement;
import java.io.ByteArrayOutputStream;
import javax.xml.namespace.QName;

public class SimpleLoggingHandler extends GenericSOAPHandler<LogicalMessageContext> {
  
  private static Logger log = Logger.getLogger("com.redhat.gss.handlers");

  public boolean handleInbound(MessageContext ctx) {
    log.info("Inbound:  " + getClass().getName());
    try {
      SOAPMessage m = ((SOAPMessageContext)ctx).getMessage();
      QName qname = new QName("http://gss.redhat.com/", "TestHeader");
      SOAPHeaderElement element = m.getSOAPHeader().addHeaderElement(qname);
      element.addTextNode("Helloooooooo");
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      m.writeTo(out);
      log.warn(out.toString());
    } catch(Exception e) {

      //nothing
    }
    return true;
  }

  public boolean handleOutbound(MessageContext ctx) {
    log.info("Outbound: " + getClass().getName());
    return true;
  }
}
