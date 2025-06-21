package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class findAllPairsOfNumbersThatSumToGivenTarget {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2, 3,4,5,7, 6, 8, 9,10,11);
        int target = 12;

        Set<String> pairs = numbers.stream()
                .flatMap(i -> numbers.stream().
                        map(j -> i + j == target ? "(" + i + ", " + j + ")" : ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toSet());
        System.out.println("Pairs that sum up to " + target + ": " + pairs);

        pairs.clear();
        pairs = numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> i + j == target)
                        .map(j -> "(" + i + ", " + j + ")"))
                .collect(Collectors.toSet());

        System.out.println("Pairs that sum up to " + target + ": " + pairs);

    }
}
