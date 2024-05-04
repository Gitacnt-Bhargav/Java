import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class findAllPairsOfNumbersThatSumToGivenTarget {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        int target = 12;

        Set<String> pairs = numbers.stream()
                .flatMap(i -> numbers.stream().
                        map(j -> i + j == target ? "(" + i + ", " + j + ")" : ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
        System.out.println("Pairs that sum up to " + target + ": " + pairs);

    }
}
