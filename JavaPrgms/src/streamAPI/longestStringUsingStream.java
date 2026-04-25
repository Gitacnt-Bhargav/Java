package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class longestStringUsingStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "kiwi");

        String longestString = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse(null);

        System.out.println(longestString);

        String shortestString = strings.stream()
                .min(Comparator.comparing(String::length))
                .orElse(null);

        System.out.println(shortestString);

        longestString = strings.stream().sorted(Comparator.comparingInt(String::length).reversed()).limit(1).findFirst().orElse(null);
        System.out.println(longestString);

        longestString = strings.stream().reduce((s, s2) -> {
            String str = s.length()>=s2.length()?s:s2;
            return str;
                })
                .orElse(null);

        System.out.println(longestString);
    }
}
