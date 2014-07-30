package com.redhat.gss.ejb;

@javax.ejb.Local
public interface SayHi {
  public String sayHi(String name);
}
