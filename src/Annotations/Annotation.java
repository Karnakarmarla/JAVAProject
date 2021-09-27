package Annotations;
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyAnnotation{
    int value();
}

class Hello{
    @MyAnnotation(value=10)
    public void sayHello(){System.out.println("hello annotation");}
}


class Annotation{
    public static void main(String args[])throws Exception{

        Hello h=new Hello();
        Method m=h.getClass().getMethod("sayHello");

        MyAnnotation mn=m.getAnnotation(MyAnnotation.class);
        System.out.println("value is: "+mn.value());
    }}