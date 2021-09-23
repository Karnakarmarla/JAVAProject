package Day1;

import java.util.Scanner;
class Solution{

    public void print_array(String ar[])
    {
        System.out.println("array elements are :");
        for(int i=0;i<ar.length;i++)
            System.out.print(ar[i]+" ");
        System.out.println();
    }

    public void last_element(String ar[])
    {
        System.out.println("Last and last but one elements :");
        if(ar.length>=1)
        System.out.println(ar[ar.length-1]);
        if(ar.length>1)
        System.out.println(ar[ar.length-2]);
    }

    public void reverse(String ar[])
    {
        int p1=0,p2= ar.length-1;
        while(p1<=p2)
        {
            String s=ar[p1];
            ar[p1]=ar[p2];
            ar[p2]=s;
            p1++;
            p2--;
        }
        System.out.println("Reversed array is :");
        for(int i=0;i<ar.length;i++)
            System.out.print(ar[i]+" ");
        System.out.println();
    }

    public boolean palindrome_array(String ar[])
    {
        int p1=0,p2= ar.length-1;
        while(p1<=p2)
        {
            if(ar[p1].equals(ar[p2]))
            {
                p1++;
                p2--;
            }
            else
                return false;
        }
        return true;
    }

    public void remove_consecutive(int ar[])
    {
        System.out.println("The resultant array is \n"+ar[0]+" ");
        for(int i=1;i<ar.length;i++)
        {
            if(ar[i-1]!=ar[i])
                System.out.print(ar[i]+" ");
        }
    }

    public void pack_duplicates(char ar[])
    {
        System.out.print("Char array after packing is \n");
        String seq=Character.toString(ar[0]);
        for(int i=1;i<ar.length;i++)
        {
            if(ar[i]==ar[i-1])
                seq+=Character.toString(ar[i]);
            else
            {
                System.out.print(seq+" ");
                seq=Character.toString(ar[i]);
            }
        }
        System.out.print(seq+" ");
    }
}
public class ArraySolution {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String breakfast[] = {"Sausage", "Eggs", "Beans", "Bacon", "Tomatoes", "Mushrooms"};

        System.out.println("Enter no of array elements");
        int n=sc.nextInt();
        int dupicates[]=new int[n];
        System.out.println("Enter array elements for duplicate array");
        for(int i=0;i<n;i++)
        {
            dupicates[i]=sc.nextInt();
        }

        System.out.println("Enter No of elements in char array");
        int m=sc.nextInt();
        char seq[]=new char[m];
        System.out.println("Enter char array elements");
        for(int i=0;i<m;i++)
            seq[i]=sc.next().charAt(0);



        Solution s1=new Solution();
        s1.print_array(breakfast);
        s1.last_element(breakfast);
        s1.reverse(breakfast);
        if(s1.palindrome_array(breakfast))
        {
            System.out.println("Yes Palindromic array");
        }
        else
            System.out.println("Not a Palindromic array");

        s1.remove_consecutive(dupicates);
        s1.pack_duplicates(seq);

    }
}
