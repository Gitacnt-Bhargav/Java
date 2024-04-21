import java.util.stream.IntStream;
import java.util.stream.Stream;

public class maxProductOfTwoIntegersInArrayUsingStream {

    public static void main(String[] args){
        int[] array = {1, 4, 3, 6, 2, 7};

        //Minimum of each iteration of i,j
        Stream<Integer> a = IntStream.range(0, array.length)
                .mapToObj(i -> IntStream.range(i + 1, array.length)
                        .map(j -> array[i] * array[j])
                        .min()
                        .orElse(Integer.MAX_VALUE));
        a.forEach(System.out::println);

        //min of all values of min of each iteration of i,j
        int minProduct = IntStream.range(0, array.length)
                .mapToObj(i -> IntStream.range(i + 1, array.length)
                        .map(j -> array[i] * array[j])
                        .min()
                        .orElse(Integer.MAX_VALUE))
                .min(Integer::compare).orElse(Integer.MAX_VALUE);
        System.out.println("Minimum Product : " + minProduct);

        //Maximum of each iteration of i,j
        Stream<Integer> b = IntStream.range(0, array.length)
                .mapToObj(i -> IntStream.range(i + 1, array.length)
                        .map(j -> array[i] * array[j])
                        .max()
                        .orElse(Integer.MIN_VALUE));
        b.forEach(System.out::println);

        //max of all values of max of each iteration of i,j
        int maxProduct = IntStream.range(0, array.length)
                .mapToObj(i -> IntStream.range(i + 1, array.length)
                        .map(j -> array[i] * array[j])
                        .max()
                        .orElse(Integer.MIN_VALUE))
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);
        System.out.println("Maximum product: " + maxProduct);
    }
}
