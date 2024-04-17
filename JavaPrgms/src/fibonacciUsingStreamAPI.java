import java.util.stream.Stream;

public class fibonacciUsingStreamAPI {

    public static void main(String[] args){
        Stream<Long> fibonacci = Stream.iterate(
                        new long[]{0, 1}, f -> new long[]{f[1], f[0] + f[1]})
                .mapToLong(f -> f[0]).boxed();
        fibonacci.limit(10).forEach(System.out::println);
    }
}
