package com.redhat.gss.ejb;

import javax.annotation.security.RolesAllowed;
import org.jboss.logging.Logger;
import org.jboss.ejb3.annotation.SecurityDomain;

@javax.ejb.Stateless
@javax.jws.WebService
@RolesAllowed("hi")
@SecurityDomain("other")
public class SayHiImpl implements SayHi {
  private static Logger log = Logger.getLogger(SayHiImpl.class);

  public String sayHi(String name) {
    log.warn("Saying hello from EJB! " + name + ".");
    return "Hi, " + name;
  }
}
