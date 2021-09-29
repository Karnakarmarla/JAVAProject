package FunctionalProgramming;
import java.util.*;
import java.util.stream.Stream;

public class FlatMapExample {
    public static void main(String args[]) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
                    String[] split = value.split(" ");
                    return (Stream<String>) Arrays.asList(split).stream();
                })
                .forEach((value) -> System.out.println(value))
        ;
    }
}
