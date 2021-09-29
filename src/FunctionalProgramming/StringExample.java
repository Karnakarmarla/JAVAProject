package FunctionalProgramming;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringExample {
    public void count_words(String s)
    {
        long count = Stream.of(s)
                .count();
        System.out.println(count);
    }
    public void count_char(String s)
    {
        s=s.toLowerCase();
        long count=s.chars()
            .filter(c -> c == 'e')
            .count();
        System.out.println("count of e is:"+count);
    }
    public void count_alphanumeric(String s)
    {
        long count= s.chars()
                .mapToObj(i -> Character.valueOf((char) i)).filter(c-> c>='A' && c<='Z' || c>='a' && c<='z' || c>='0' && c<='9')
                .count();

        System.out.println("count of alphanumerics are:"+count);
    }

    public void reverse(String string)
    {
        String rev=Stream.of(string)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        System.out.println("Reversed string is:"+rev);
    }

    public void palindrome(String string)
    {
        String rev=Stream.of(string)
                .map(word->new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
        if(string.equals(rev))
            System.out.println("palindrome");
        else
            System.out.println("Not a palindrome");
    }
    public static void main(String args[]){
        StringExample ex=new StringExample();
        ex.count_words("Hi Hello welcome");
        ex.count_alphanumeric("wer-5tfcvb-");
        ex.count_char("heeelle");
        ex.reverse("Hello");
        ex.palindrome("sosos");

    }
}
