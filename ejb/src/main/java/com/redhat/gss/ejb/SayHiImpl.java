package com.redhat.gss.ejb;

import javax.annotation.security.RolesAllowed;
import org.jboss.logging.Logger;

@javax.ejb.Stateless
@javax.jws.WebService
@RolesAllowed("hello")
public class SayHiImpl implements SayHi {
  private static Logger log = Logger.getLogger(SayHiImpl.class);

  public String sayHi(String name) {
    log.warn("Saying hello from EJB! " + name + ".");
    return "Hi, " + name;
  }
}