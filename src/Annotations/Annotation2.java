package Annotations;

class MySuperClass {
    public void doTheThing() {
        System.out.println("Do the thing");
    }
}

class MySubClass extends MySuperClass{

    @Override
    public void doTheThing() {
        System.out.println("Do it differently");
    }
}

public class Annotation2 {
    public static void main(String args[])
    {
        MySubClass sub=new MySubClass();
        sub.doTheThing();
    }
}
