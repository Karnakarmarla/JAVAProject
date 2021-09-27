package Annotations;

class UsingDeprecated
{
    @Deprecated
    public void Display()
    {
        System.out.println("Deprecated display method");
    }
}

public class Annotation3
{
    @SuppressWarnings({"checked", "deprecation"})
    public static void main(String args[])
    {
        UsingDeprecated d1 = new UsingDeprecated();
        d1.Display();
    }
}
