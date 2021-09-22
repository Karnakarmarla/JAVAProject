package JavaCollections;
import java.util.Scanner;

class Arithmetic
{
    public boolean is_prime(int n)
    {
        if(n<2)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public void prime_range(int a,int b)
    {
        System.out.println("prime numbers b/w "+a+" and "+b+" are: ");
        for(int i=a;i<=b;i++)
        {
            if(is_prime(i))
                System.out.print(i+" ");
        }
        System.out.println();
    }

    public int gcd(int a,int b)
    {
        while(b!=0)
        {
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }

    public boolean is_coprime(int a,int b)
    {
        if(gcd(a,b)==1)
            return true;
        else
            return false;
    }

    public int phi(int m)
    {
        if(m==1)
            return 1;
        int count=0;
        for(int i=1;i<m;i++)
        {
            if(gcd(i,m)==1)
            count++;
        }
        return count;
    }

    public void primefactors(int n)
    {  System.out.println("The prime factors of "+n+" are :");
        while(n%2==0)
        {
            System.out.print(2+" ");
            n/=2;
        }
        for(int i=3;i*i<=n;i+=2)
        {
            while(n%i==0)
            {
                System.out.print(i+" ");
                n=n/i;
            }
        }
        if(n>2)
            System.out.print(n);
    }

    public int[] goldbach_pair(int n)
    {
        int ans[]=new int[2];
        int i=2;
        while(i<=n/2)
        {
            if(is_prime(i) && is_prime(n-i))
            {
                ans[0]=i;
                ans[1]=n-i;
                break;
            }
            i++;
        }
        return ans;
    }

    public int more_goldbach_pair(int a,int b)
    {
        int count=0;
        for(int i=a;i<=b;i++)
        {
            int ans[]=goldbach_pair(i);
            if(ans[0]>50 && ans[1]>50)
                count++;
            System.out.println("The goldbach pair for "+i+" are:"+ans[0]+","+ans[1]);
        }
        return count;
    }



}

public class ArithmeticSolution {

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Arithmetic arithmetic=new Arithmetic();

        System.out.println("Enter a number for isprime");
        int n=sc.nextInt();
        if(arithmetic.is_prime(n))
            System.out.println(n+" is a prime");
        else
            System.out.println("Not a prime");

        System.out.println("Enter two numbers for gcd check");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("GCD of "+a+" and "+b+" is "+arithmetic.gcd(a,b));

        arithmetic.prime_range(a,b);
        arithmetic.primefactors(a);

        System.out.println("Enter two numbers for coprime check");
        a=sc.nextInt();
        b=sc.nextInt();
        if(arithmetic.is_coprime(a,b))
            System.out.println(a+" and "+b+" are coprimes");
        else
            System.out.println("Not coprimes");

        System.out.println("Enter a number for totient function");
        int m=sc.nextInt();
        System.out.println("The no of coprimes with "+m+" are "+arithmetic.phi(m));

        System.out.println("Enter a number for goldbachpair:");
        n=sc.nextInt();
        int res[]=arithmetic.goldbach_pair(n);
        if(res[0]==0&&res[1]==0)
            System.out.println("There is No goldbach pair for "+n);
        else
            System.out.println("the goldbach pair for "+n+" are :"+res[0]+","+res[1]);

        System.out.println("Enter range for goldbach pair");
        int x=sc.nextInt();
        int y=sc.nextInt();
        int ans=arithmetic.more_goldbach_pair(x,y);
        System.out.println("No of pairs greater than 50 are:"+ans);
    }
}
