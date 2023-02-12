package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LambdaUsage {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("eeeee", "a",  "ccc", "dddd", "bb");
        AtomicInteger count = new AtomicInteger(1);
        Comparator<String> comparator = (left, right) -> {
            System.out.println(" [Iteration " + count + ": Compare " + left + " and "  + right + "]");
            count.getAndIncrement();
            return  Integer.compare(right.length(), left.length());
        };
        strings.sort(comparator);

        for (String str : strings) {
            System.out.println(str);
        }
    }
}
