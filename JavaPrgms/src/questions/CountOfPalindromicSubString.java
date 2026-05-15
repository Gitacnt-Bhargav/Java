package questions;

public class CountOfPalindromicSubString {
//    Leet code - 647 - Medium
/*
Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/

    public static void main(String[] args) {
        CountOfPalindromicSubString countOfPalindromicSubString = new CountOfPalindromicSubString();
//        String s = "aaa";
        String s = "abc";
        int count = countOfPalindromicSubString.countOfPalindromicStrings(s);
        System.out.println(count);
    }

    public int countOfPalindromicStrings(String str){
        int count = 0;

        for(int i=0;i <str.length();i++){
            int count1 = expand(str,i,i);
            int count2 = expand(str, i,i+1);

            count += count1 + count2;
        }

        return count;
    }

    public int expand(String str, int left, int right){
        int count = 0;
        while(left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
