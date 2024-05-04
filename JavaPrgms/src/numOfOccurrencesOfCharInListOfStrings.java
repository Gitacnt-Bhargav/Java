import java.util.Arrays;
import java.util.List;

public class numOfOccurrencesOfCharInListOfStrings {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "melon");
        char target = 'a';

        strings.stream().flatMapToInt(String::chars).forEach(System.out::println);
        long occurrences = strings.stream().flatMapToInt(String::chars).filter(e -> e==target).count();
        System.out.println(occurrences);
    }
}
