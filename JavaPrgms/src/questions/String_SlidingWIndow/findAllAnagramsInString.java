package questions.String_SlidingWIndow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findAllAnagramsInString {

//    Leet code - 438 - Medium

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

Constraints:
1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
*/

    public static void main(String[] args) {
        findAllAnagramsInString findAllAnagramsInString = new findAllAnagramsInString();
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> allAnagrams = findAllAnagramsInString.findAllAnagrams(s, p);
        System.out.println(allAnagrams.toString());
    }

    public List<Integer> findAllAnagrams(String s, String p){

        //here, we are maintaining a map where firstly we add all req chars which are present in p
        //if some character is found by right pointer in s then value corresponding to that is reduced in map
        //counter increase and decrease to be done based on req chars
        //if some value in map for a char is less than 0, it means that it is not req column or leaving behind that char is ok

        List<Integer> output = new ArrayList<>();
        if(s.length() < p.length()) return output;

        int counter = p.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i),0)+1);
        }

        int left = 0;
        for(int right = 0; right <s.length(); right++){

            //match char with req or not and then decrease counter
            //check length of windowSize, if greater, increase left pointer
            //redo all things that right pointer did when left pointer leaves one character

            char ch = s.charAt(right);

            int val = map.getOrDefault(ch,0);

            if(val > 0) counter--; // this means that the required char is one reduced since we came across.
            // Something in map > 0 means that char is a req char
            map.put(ch,val-1);

            if(right - left + 1 > p.length()){
                if(map.get(s.charAt(left))>=0) counter++; // this means that the required char is left behind and so counter is increased
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)+1);
                left++;
            }

            if(counter ==0) output.add(left);
        }
        return output;
    }
}
