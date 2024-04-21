import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

record Employee(String name,String branch, int salary) {
    public String getName() {
        return this.name;
    }
}

public class employeeStreamOperations {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Muna", "IT", 7500),
                new Employee("Runa", "HR", 90000),
                new Employee("Kuna", "Finance", 60000),
                new Employee("Miku", "IT", 75000),
                new Employee("Sonu", "IT", 24000),
                new Employee("mark", "HR", 65000)
        );

        // Filter words that start with "M"
        List<Employee> emp = employees.stream()
                .filter(employee -> employee.getName().startsWith("M"))
                .toList();
        System.out.println("Filtered words: " + emp); // approach 1 to display emp whose name start with "M"
        emp.forEach(employee -> System.out.println(employee.getName()));  // approach 2 to display emp whose name start with "M"
        emp.forEach(System.out::println); //  // approach 3 to display emp whose name start with "M"

        // Map words to uppercase

        List<String> uppercaseWords  =  employees.stream().map(employee -> employee.getName()
                        .toUpperCase())
                .toList();
        System.out.println(uppercaseWords); // [MUNA, RUNA, KUNA, MIKU, SONU, MARK]

        List<String> sortedEmployeeName  =  employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(sortedEmployeeName); // [Kuna, Miku, Muna, Runa, Sonu, mark]


        List<String> words = Arrays.asList("hello","hello","world", "world", "java", "stream", "example");

        List<String> distinctEords  = words.stream().distinct().toList();
        System.out.println("distinct words" + distinctEords);

        List<String> sorted = words.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted); //[world, world, stream, java, hello, hello, example]

        List<String> skipItem = words.stream().skip(2).toList();
        System.out.println(skipItem); //[world, world, java, stream, example]

        List<String> limitItem = words.stream().distinct().limit(3).toList();
        System.out.println(limitItem); //[hello, world, java]

    }
}