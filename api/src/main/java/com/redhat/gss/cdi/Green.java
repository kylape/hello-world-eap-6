package com.redhat.gss.cdi;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.inject.Qualifier;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Green {
}
