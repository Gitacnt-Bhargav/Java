package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class highestFreqCharInString {

    public static void main(String[] args){
        String str = "aabbbbcbcccc sadsdaaa";

        long val = str.chars().mapToObj(e -> (char)e).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).values().stream().mapToLong(Long::longValue).max().orElse(0L);

        str.chars().mapToObj(e -> (char)e).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(e -> e.getValue() == val).forEach(e -> System.out.println(e.getKey()));
    }
}
