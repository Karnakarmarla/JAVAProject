package JavaCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution
{
    public void tictactoe()
    {
        String ar[][]=new String[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                ar[i][j]="X";
            }
        }

        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(" | "+ar[i][j]);
            }
            System.out.println(" |");
        }
    }

    public void chessboard()
    {
        String ar[][]=new String[8][8];
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if((i+j)%2==0)
                    ar[i][j]="X";
                else
                    ar[i][j]="O";
            }
        }

        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                System.out.print(" | "+ar[i][j]);
            }
            System.out.println(" |");
        }
    }

    public void digits_to_words(String s)
    {
        String[] digits={"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            ans=ans+digits[Integer.parseInt(s.substring(i,i+1))]+" ";
        }
        System.out.println(ans);
    }

    public void time_to_words(String s)
    {
        String time[]= s.split(":");
        int h=Integer.parseInt(time[0]);
        int m=Integer.parseInt(time[1]);
        String words[] = { "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen",
                "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one",
                "twenty two", "twenty three", "twenty four",
                "twenty five", "twenty six", "twenty seven",
                "twenty eight", "twenty nine"};

        if (m == 0)
            System.out.println(words[h] + " 'o' clock ");
        else if (m == 1)
            System.out.println("one minute past " +words[h]);
        else if (m == 59)
            System.out.println("one minute to " +words[(h % 12) + 1]);
        else if (m == 15)
            System.out.println("quarter past " +words[h]);
        else if (m == 30)
            System.out.println("half past " +words[h]);
        else if (m == 45)
            System.out.println("quarter to " +words[(h % 12) + 1]);
        else if (m <= 30)
            System.out.println(words[m] + " minutes past " +words[h]);
        else if (m > 30)
            System.out.println(words[60 - m] + " minutes to " + words[(h % 12) + 1]);
    }

    public String morsecode(String s)
    {
        s=s.toLowerCase();
        String code[] = {".-","-...","-.-.","-..",".","..-.","--.", "....", "..", ".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.", "...","-","..-","...-",".--","-..-","-.--","--..", "/"};
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                ans+=code[26]+" ";
            }
            else
            {
                ans+=code[s.charAt(i)-97]+" ";
            }
        }
        System.out.println(ans);
        return ans;
    }

    public void demorse(String s)
    {
        String code[] = {".-","-...","-.-.","-..",".","..-.","--.", "....", "..", ".---","-.-",".-..",
                "--","-.","---",".--.","--.-",".-.", "...","-","..-","...-",".--","-..-","-.--","--..", "/"};
        String ans="";
        String W[]=s.split("\\s+");
        for(String x:W)
        {
            if(x.equals("/"))
                ans+=" ";
            else
            {
                for(int i=0;i<code.length;i++)
                {
                    if(x.equals(code[i]))
                    {
                        char c=(char)(i+97);
                        ans+=Character.toString(c);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    public String morse_hashmap(String s)
    {
        HashMap<String,String> hm=new HashMap<String,String>();
        hm.put("a" , ".-");
        hm.put("b" , "-...");
        hm.put("c" , "-.-.");
        hm.put("d" , "-..");
        hm.put("e" , ".");
        hm.put("f" , "..-.");
        hm.put("g" , "--.");
        hm.put("h" , "....");
        hm.put("i" , "..");
        hm.put("j" , ".---");
        hm.put("k" , "-.-");
        hm.put("l" , ".-..");
        hm.put("m" , "--");
        hm.put("n" , "-.");
        hm.put("o" , "---");
        hm.put("p" , ".--.");
        hm.put("q" , "--.-");
        hm.put("r" , ".-.");
        hm.put("s" , "...");
        hm.put("t" , "-");
        hm.put("u" , "..-");
        hm.put("v" , "...-");
        hm.put("w" , ".--");
        hm.put("x" , "-..-");
        hm.put("y" , "-.--");
        hm.put("z" , "--..");
        hm.put(" " , "/");

        s=s.toLowerCase();
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            ans+=hm.get(s.substring(i,i+1))+" ";
        }
        System.out.println(ans);
        return ans;
    }

    public void demorse_hashmap(String s)
    {
        HashMap<String,String> hm=new HashMap<String,String>();
        hm.put("a" , ".-");
        hm.put("b" , "-...");
        hm.put("c" , "-.-.");
        hm.put("d" , "-..");
        hm.put("e" , ".");
        hm.put("f" , "..-.");
        hm.put("g" , "--.");
        hm.put("h" , "....");
        hm.put("i" , "..");
        hm.put("j" , ".---");
        hm.put("k" , "-.-");
        hm.put("l" , ".-..");
        hm.put("m" , "--");
        hm.put("n" , "-.");
        hm.put("o" , "---");
        hm.put("p" , ".--.");
        hm.put("q" , "--.-");
        hm.put("r" , ".-.");
        hm.put("s" , "...");
        hm.put("t" , "-");
        hm.put("u" , "..-");
        hm.put("v" , "...-");
        hm.put("w" , ".--");
        hm.put("x" , "-..-");
        hm.put("y" , "-.--");
        hm.put("z" , "--..");
        hm.put(" " , "/");
        String code[]=s.split("\\s+");
        String ans="";
        for(int i=0;i<code.length;i++)
        {
           for(Map.Entry<String,String> entry:hm.entrySet())
           {
               if(entry.getValue().equals(code[i]))
                   ans+= entry.getKey();
           }
        }
        System.out.println(ans);
    }

}
public class StringArrayCollection {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Solution s1=new Solution();
        s1.tictactoe();
        s1.chessboard();
        System.out.println("Enter a number :");
        String s=sc.next();
        s1.digits_to_words(s);
        System.out.println("Enter a time:");
        s=sc.next();
        s1.time_to_words(s);
        System.out.println("Enter a string:");
        sc.nextLine();
        String L=sc.nextLine();
        String decode=s1.morsecode(L);
        s1.demorse(decode);
        String decode1=s1.morse_hashmap(L);
        s1.demorse_hashmap(decode1);

    }
}
