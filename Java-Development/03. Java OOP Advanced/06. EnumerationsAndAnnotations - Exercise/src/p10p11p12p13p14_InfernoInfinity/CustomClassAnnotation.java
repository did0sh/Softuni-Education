package p10p11p12p13p14_InfernoInfinity;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CustomClassAnnotation {
    String author();
    int revision();
    String description();
    String[] reviewers();
}
