package streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class alphaOrderInList{

    public static void main(String[] args) {

        List<String> browsers = Arrays.asList("Safari", "Edge", "IE", "Chrome", "Chrome");
        CustomArrayList<String> browserOp = new CustomArrayList<>();
        CustomArrayList<String> browserReverseOp = new CustomArrayList<>();

        for(String i : browsers){
            browserOp.add(sortCharArray(i.toLowerCase()));
        }

        System.out.println("sort each string in input Array List and adding after removing duplicates");
        browserOp.forEach(System.out::println);

        for(String i : browsers){
            browserReverseOp.add(new StringBuilder(i).reverse().toString());
        }

        System.out.println("Reverse each string in input Array List and adding after removing duplicates");
        browserReverseOp.forEach(System.out::println);
    }

    public static String sortCharArray(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}

