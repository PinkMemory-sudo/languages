package collection.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        List<String> stringList = IntStream.range(1, 10).boxed().map(String::valueOf).collect(Collectors.toList());
        for (String s : stringList) {
            stringList.remove(s);
        }
        System.out.println(stringList);
    }
}
