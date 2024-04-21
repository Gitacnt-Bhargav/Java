import java.util.Arrays;
import java.util.List;

public class longestCommonPrefixUsingStream {

    public static void main(String[] args){

        List<String> strings = Arrays.asList("flower", "flow", "flight");
        String longestPrefix = strings.stream().reduce((s1,s2)->{
            int length = Math.min(s1.length(),s2.length());
            int i = 0;
            while (i < length && s1.charAt(i)==s2.charAt(i)){
                i++;
            }
            return s1.substring(0,i);
        }
        ).orElse("");

        System.out.println(longestPrefix);

    }
}
