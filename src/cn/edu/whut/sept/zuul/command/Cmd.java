package cn.edu.whut.sept.zuul.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
/**
 * 自定义注解，此项目中的所有命令类都要加上该注解
 */
public @interface Cmd {
    String value();
}
