package questions.String_SlidingWIndow;

import java.util.HashSet;

public class largestSubString {

//    leet code - 3 - medium
/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

    public static void main(String[] args) {
        largestSubString largestSubString = new largestSubString();
//        String s = "bbbbb";
//        String s = "abcabcbb";
//        String s = "pwwkew";
        String s = " ";
//        String s = "au";
        int result = largestSubString.lengthOfLargestSubString(s);
        System.out.println(result);
    }

    public Integer lengthOfLargestSubString(String s){
        int max = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
//        if(s.length()==1) return 1;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, right - left);
        }

        return  max;
    }
}
