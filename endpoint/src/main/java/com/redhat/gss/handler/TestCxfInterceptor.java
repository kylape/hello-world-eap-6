package com.redhat.gss.handler;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.jboss.logging.Logger;
import java.io.ByteArrayOutputStream;
import javax.xml.soap.SOAPMessage;

public class TestCxfInterceptor extends AbstractPhaseInterceptor<Message> {
  private static Logger log = Logger.getLogger(TestCxfInterceptor.class);

  public TestCxfInterceptor() {
    super(Phase.UNMARSHAL);
  }

  public void handleMessage(Message message) {
    log.info("TestCxfInterceptor");
    try {
      SOAPMessage m = message.getContent(SOAPMessage.class);
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      m.writeTo(out);
      log.warn(out.toString());
    } catch(Exception e) {
    }
  }
}
