package streamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class repititionOfEachChar {

    public static void main(String[] args) {
        String str = "wwwaaaabbbbbbccccccd";
        str.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s))).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(e-> e.getValue()!=1)
                .forEach(n -> System.out.println(n.getKey() + " " + n.getValue()));

        System.out.println("Complete output: \n");
        Map<Character, Long> mp =
                str.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char)s))).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//                mp.keySet().forEach(n -> System.out.println(n + " " + mp.get(n)));
                System.out.println(mp.get('a'));

    }
}
