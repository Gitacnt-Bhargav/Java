import java.util.Arrays;
import java.util.List;

public class longestStringUsingStream {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "orange",
                "grape", "kiwi");

        String longestString = strings.stream()
                .max((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .orElse(null);

        System.out.println(longestString);
    }
}
