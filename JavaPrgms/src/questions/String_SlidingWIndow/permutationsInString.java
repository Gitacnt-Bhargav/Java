package questions.String_SlidingWIndow;

import java.util.HashMap;

public class permutationsInString {

//    Leet code - 567 - Medium
/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
1 <= s1.length, s2.length <= 10^4
s1 and s2 consist of lowercase English letters.
*/
    public static void main(String[] args) {
        permutationsInString permutationsInString = new permutationsInString();
        String s1= "ab";
        String s2= "eidboaoo";
        System.out.println(permutationsInString.permutationInString(s1,s2));
    }

    public Boolean permutationInString(String s1, String s2){
        if(s1.length() > s2.length()) return false;
        int l1 = s1.length();
        int left=0, right=0;
        int count = l1;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<l1; i++)
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0) + 1);

        while(right < s2.length()){
            map.put(s2.charAt(right),map.getOrDefault(s2.charAt(right),0)- 1);
            if(map.get(s2.charAt(right)) >=0) count--;

            if(count==0) return true;
            if(right -left +1 == l1) {
                if(map.get(s2.charAt(left))>=0) count++;
                map.put(s2.charAt(left), map.getOrDefault(s2.charAt(left),0)+1);
                left++;
            }

            right++;
        }
        return false;
    }
}
