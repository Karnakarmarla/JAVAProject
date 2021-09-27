package Annotations;
import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface MyCustomAnnotation{
    int studentAge() default 18;
    String studentName();
    String stuAddress();
    String stuStream() default "CSE";
}

@MyCustomAnnotation(
        studentName="Karnakar",
        stuAddress="Hyderabad"
)
public class CustomAnnotation {
    public static void main(String args[]){
        Class<CustomAnnotation> aClass = CustomAnnotation.class;
        MyCustomAnnotation annotation = (MyCustomAnnotation) aClass.getAnnotation(MyCustomAnnotation.class);

        if(annotation instanceof MyCustomAnnotation){
            MyCustomAnnotation myAnnotation = (MyCustomAnnotation) annotation;
            System.out.println("Student name: " + myAnnotation.studentName());
            System.out.println("Student dept: " + myAnnotation.stuStream());
            System.out.println("Student Address: " + myAnnotation.stuAddress());
        }

    }
}
