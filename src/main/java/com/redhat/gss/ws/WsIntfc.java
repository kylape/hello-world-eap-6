package com.redhat.gss.ws;

import javax.jws.WebMethod;
import java.util.List;

@javax.jws.WebService(
  targetNamespace="http://ws.gss.redhat.com/"
)
public interface WsIntfc {
  @WebMethod
  public List<String> sayHello(List<String> names);
}
