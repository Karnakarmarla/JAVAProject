package Day1;
import java.util.Scanner;

public class PowerEven {

    public void random()
    {
        System.out.println("The four radom numbers are");
         for(int i=1;i<=4;i++)
        {
            System.out.println((int)(Math.random()*10)+1);
        }
    }

    public void evennumbers(int n)
    {
        System.out.println("Even numbers less than "+n);
        for(int i=2;i<n;i+=2)
            System.out.println(i);
    }

    public void power2(int n)
    {
        System.out.println("Power of 2 upto  "+n);
        for(int i=1;i<=n;i++)
            System.out.println(1<<i);
    }

    public void arewethere(Scanner sc)
    {
        System.out.println("are we there output");
        do
        {
            System.out.println("Are we there yet");
        }while(!sc.next().equals("Yes"));
        System.out.println("Good!");
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter input for even numbers ");
        int n=sc.nextInt();
        System.out.println("Enter input for power of two");
        int m=sc.nextInt();
        PowerEven powereven=new PowerEven();
        powereven.random();
        powereven.evennumbers(n);
        powereven.power2(m);
        powereven.arewethere(sc);


    }

}
