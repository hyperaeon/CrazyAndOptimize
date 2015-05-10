package com.crazy.chapter14;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Testable {

	boolean value() default true;
}
