package FunctionalProgramming;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;


public class IntStreamExample {
    public void onetoten()
    {
        IntStream.range(1, 11).forEach(
                val -> System.out.println(val));

        IntStream.rangeClosed(1, 10).forEach(System.out::println);
    }
    public void printodd()
    {
        IntStream.range(1, 20).filter(val->val%2==1).forEach(
                val -> System.out.println(val));
    }

    public void power2(int n)
    {
        System.out.println("Power of 2 upto  "+n);
        IntStream.range(1, 11).map(val->(int)Math.pow(2,val)).forEach(
                val -> System.out.println(val));

    }
    public void squares()
    {
        IntStream.range(1, 11).map(val->val*val).forEach(
                val -> System.out.println(val));
    }
    public void print_array(List<String> ar)
    {
       Stream<String> stream=ar.stream();
       stream.forEach(System.out::println);
    }

    public void reverse(String ar[])
    {
        List<String> sortedList = Arrays.asList(ar).stream()
                .sorted( (i1, i2) -> i2.compareTo(i1) )
                .collect(Collectors.toList());

        System.out.println(sortedList);
    }

    public void remove_consecutive(int ar[])
    {
        IntStream stream = Arrays.stream(ar);
        stream.distinct().forEach(x -> System.out.println(x));
    }

    public static void main(String args[]) {
       IntStreamExample ex=new IntStreamExample();
       ex.printodd();
       ex.onetoten();
       ex.power2(5);
       ex.squares();
        String breakfast[] = {"Sausage", "Eggs", "Beans", "Bacon", "Tomatoes", "Mushrooms"};
       List<String> ar=Arrays.asList(breakfast);
       ex.print_array(ar);
       ex.remove_consecutive(new int[]{22,34,32,654,123});
    }
}
