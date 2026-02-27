package com.howard.annotation;

public @interface EnhanceElement {
    int id()default 0;
    String synopsis() default "[unSynopsis]";
    String engineer() default"[unassigned]";
    String date() default"[unimplemented]";

}
