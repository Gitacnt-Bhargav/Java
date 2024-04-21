import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class streamTerminalOperations {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 3, 5, 1);

        // Example 1: Collecting elements into a List and set

        List<Integer> integers = numbers.stream()
                .map(num -> num * 10)
                .collect(Collectors.toList());
        System.out.println(integers);

        Set<Integer> intMaps = numbers.stream()
                .map(num -> num * 10)
                .collect(Collectors.toSet());
        System.out.println(intMaps);

        // Example 2: Counting elements in the stream

        long numberCount = numbers.stream().distinct().count();
        System.out.println(numberCount);

        // Example 3: Checking if any element is greater than 3 anyMatch

        boolean anyGreaterThan2 = numbers.stream().anyMatch(num -> num > 2);
        System.out.println("Any number greater than 2? " + anyGreaterThan2);

        boolean noneMatch = numbers.stream().noneMatch(num -> num > 20);
        System.out.println(noneMatch);

        boolean allMatch = numbers.stream().allMatch(num -> num > 0);
        System.out.println(allMatch);

        // Example 4: Reducing elements to find the sum

        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

}
