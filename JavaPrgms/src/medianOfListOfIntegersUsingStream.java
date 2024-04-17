import java.util.Arrays;
import java.util.List;

public class medianOfListOfIntegersUsingStream {

    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(5, 2, 1, 3, 4);
        double median = numbers.stream()
                .mapToInt(Integer::intValue).summaryStatistics().getAverage();
        System.out.println("Median: " + median);
    }
}
