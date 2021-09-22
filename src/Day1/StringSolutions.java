package Day1;

import java.util.Locale;
import java.util.Scanner;

class Solution2
{
    public void count_words(String s)
    {
        String ar[]=s.split(" ");
        System.out.println("No of words are :"+ar.length);
    }

    public void count_char(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if (s.charAt(i) == 'e')
                count++;
        }
        System.out.println("count of e is:"+count);
    }

    public void count_alphanumeric(String s)
    {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            if(c>='A' && c<='Z' || c>='a' && c<='z' || c>='0' && c<='9')
                count++;
        }
        System.out.println("count of alphanumerics are:"+count);
    }

    public void reverse(String s)
    {
        String rev="";
        for(int i=0;i<s.length();i++)
            rev=s.substring(i,i+1)+rev;
        System.out.println("Reversed string is:"+rev);
    }

    public boolean palindrome(String s)
    {
        s=s.toLowerCase();
        s=s.replaceAll("[^a-z0-9]","");
        int p1=0,p2= s.length()-1;
        while(p1<=p2)
        {
            if(s.charAt(p1)==s.charAt(p2))
            {
                p1++;
                p2--;
            }
            else
                return false;
        }
        return true;
    }

    public void remove_vowels(String s)
    {
        s=s.replaceAll("[aeiouAEIOU]","*");
        System.out.println("String after replacing vowels :"+s);
    }

    public void replace_hyphens(String s)
    {
        s=s.toUpperCase();
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            ans+=Character.toString(s.charAt(i))+"-";
        }
        ans=ans.replaceAll("-\\s+-|-$"," ");
        System.out.println("The resultant string is:"+ans);
    }

    public String encoding(String s)
    {
        String ans="";
        s=s.toLowerCase();
        String list[]=s.split(" ");
        for(String w:list)
        {
            for(int i=0;i<w.length();i++)
            {
                if(i!=w.length()-1)
                    ans+=((int)w.charAt(i)-96)+",";
                else
                    ans+=((int)w.charAt(i)-96)+" ";
            }
        }
       return ans;
    }

    public void decoding(String s)
    {
        String ans="";
        String words[]=s.split(" ");
        for(String W: words)
        {
            String num[]=W.split(",");
            for(String x:num)
            {
                ans+=Character.toString((char)(Integer.parseInt(x)+96));
            }
            ans+=" ";
        }
        System.out.println("String after decoding :"+ans);
    }
}

public class StringSolutions {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter input:");
        String input=sc.nextLine();
        Solution2 s2=new Solution2();
        s2.count_words(input);
        s2.count_char(input);
        s2.count_alphanumeric(input);
        if(s2.palindrome(input))
            System.out.println("Yes Palindrome");
        else
            System.out.println("Not a palindrome");
        s2.remove_vowels(input);
        s2.replace_hyphens(input);
        s2.reverse(input);
        String decode=s2.encoding(input);
        System.out.println("String after encoding :"+decode);
        s2.decoding(decode);


    }
}
