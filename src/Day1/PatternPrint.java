package Day1;

import java.util.Scanner;

public class PatternPrint {
    public void triangle_pattern()
    {
        for(int i=1;i<=5;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void square_pattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                System.out.print("| "+i*j+" ");
            }
            System.out.println("|");
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter input for squarepattern");
        int n=sc.nextInt();
        PatternPrint pp=new PatternPrint();
        pp.triangle_pattern();
        pp.square_pattern(4);
        pp.square_pattern(n);
    }


}
