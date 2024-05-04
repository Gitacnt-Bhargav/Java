import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class findAllAnagramsInListOfStrings {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "hello",
                "world", "night", "thing");
        Map<String, List<String>> anagrams = words.stream()
                .collect(Collectors.groupingBy(str -> {
                    char[] chars = str.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
        System.out.println("Anagrams: " + anagrams);
    }
}
