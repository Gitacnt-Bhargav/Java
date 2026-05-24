package questions.String_SlidingWIndow;

import java.util.Arrays;

public class minimumWindowSubString {

    //    Leet code - 76 - Hard
/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every
character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:
m == s.length
n == t.length
1 <= m, n <= 10^5
s and t consist of uppercase and lowercase English letters. //when this is given, use array of fixed length instead of map. Map
would use hashing which takes higher processing
*/
    public static void main(String[] args) {
        minimumWindowSubString minimumWindowSubString = new minimumWindowSubString();
//        String s="ADOBECODEBANC";
//        String t="ABC";
        String s="a";
        String t="a";
//        String s="A";
//        String t="B";
//        String result = minimumWindowSubString.minWindowSubStr(s,t);
        String result = minimumWindowSubString.minWindowSubStr_optimized(s,t);
        System.out.println(result);
    }

    public String minWindowSubStr(String s, String t){
        String result = "";
        if(s.length() < t.length()) return "";

        int[] freq1 = new int[58];
        int[] freq2 = new int[58];

        for(int i=0; i<t.length(); i++)
            freq1[t.charAt(i) - 'A']++;
        int minLen = s.length();
        int left = 0;
        for(int right = 0; right <s.length(); right++){
            freq2[s.charAt(right) - 'A']++;

            while(match(freq1, freq2)){
                result = minLen<right-left+1 ? result : s.substring(left, right+1);
                minLen = result.length();
                freq2[s.charAt(left) - 'A']--;
                left++;
//                System.out.println(left + " - " + right + " - " + Arrays.toString(freq2) + " - "+ s.substring(left, right+1) + " - ");
//                System.out.print(result);
            }
        }
        return result;
    }

    public boolean match(int[] freq1, int[] freq2){
        for(int i =0; i<58; i++){
            if(freq2[i]<freq1[i]) return false; //here since we do not need exact match, we can see if all that t contains is
            //present in s, if any one is missing return false. suppose s has no A and t has one A, then t is actually not substring
            //of s. Basically, s should have all that t has more than or equal to that freq.
        }
        return true;
    }

    public String minWindowSubStr_optimized(String s, String t){
        String result = "";
        if(s.length() < t.length()) return "";
        int counter = t.length();
        int[] freq1 = new int[58];

        for(int i=0; i<t.length(); i++)
            freq1[t.charAt(i) - 'A']++;
        int minLen = s.length();
        int left = 0;
        for(int right = 0; right <s.length(); right++){
            freq1[s.charAt(right) - 'A']--;
            if(freq1[s.charAt(right) - 'A'] >=0) counter--;
            while(counter==0){
                result = minLen<right-left+1 ? result : s.substring(left, right+1);
                minLen = result.length();
//                System.out.print(left + " - " + right + " - " + counter + " - "+ s.substring(left, right+1) + " - ");
//                System.out.println(result);
                freq1[s.charAt(left) - 'A']++;
                if(freq1[s.charAt(left) - 'A'] >0) counter++;
                left++;
            }
        }
        return result;
    }

}
