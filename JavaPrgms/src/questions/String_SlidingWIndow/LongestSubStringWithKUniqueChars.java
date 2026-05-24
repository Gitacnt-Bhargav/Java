package questions.String_SlidingWIndow;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithKUniqueChars {

//    GFG - https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
/*
You are given a string s consisting only lowercase alphabets and an integer k.
Your task is to find the length of the longest substring that contains exactly k distinct characters.

Note : If no such substring exists, return -1.

Examples:
Input: s = "aabacbebebe", k = 3
Output: 7
Explanation: The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.

Input: s = "aaaa", k = 2
Output: -1
Explanation: There's no substring with 2 distinct characters.

Input: s = "aabaaab", k = 2
Output: 7
Explanation: The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

Constraints:
1 ≤ s.size() ≤ 105
1 ≤ k ≤ 26
*/

    public static void main(String[] args) {
        LongestSubStringWithKUniqueChars longestSubStringWithKUniqueChars = new LongestSubStringWithKUniqueChars();
        String s = "aabaaab";
        int k = 2;
//        int result = longestSubStringWithKUniqueChars.longestSubString(s,k);
        int result = longestSubStringWithKUniqueChars.longestSubString1(s,k);
        System.out.println(result);
    }

    public int longestSubString(String s, int k){
        int maxLength = -1;
        int left=0, right=0;
        HashMap<Character,Integer> map = new HashMap();
        int leftVal = 0;
        while(right<s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                leftVal = map.get(s.charAt(left));
                map.put(s.charAt(left),--leftVal);
                if(leftVal==0) map.remove(s.charAt(left));
                left++;
            }
            right++;
            if(map.size()==k) maxLength = Math.max(maxLength, right-left);
        }

        return maxLength;
    }

    public int longestSubString1(String s, int k){
        int maxLength = -1;
        int left=0, right=0;
        int[] freq = new int[26];
        int leftVal = 0, rightVal = 0;
        int distinct=0;
        while(right<s.length()){
            rightVal = s.charAt(right) - 'a';
            if(freq[rightVal]==0) distinct++;
            freq[rightVal]++;
//            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(distinct>k){
                leftVal = s.charAt(left) - 'a';
                freq[leftVal]--;
                if(freq[leftVal]==0) distinct--;
                left++;
            }
            right++;
            if(distinct==k) maxLength = Math.max(maxLength, right-left);
        }

        return maxLength;
    }
}
