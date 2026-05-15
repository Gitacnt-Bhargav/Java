package questions;

public class LongestPalindromicSubString {

//    leet code - 5 - Medium
/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

    public static void main(String[] args) {
        LongestPalindromicSubString longestPalindromicSubString = new LongestPalindromicSubString();
//        String str = "babad";
        String str = "cbbd";
        String result =  longestPalindromicSubString.longestPalindromicSubString(str);
        System.out.println(result);
    }

    public String longestPalindromicSubString(String str){
        int start = 0, end=0;
        for(int i=0; i<str.length(); i++){
            int len1 = expandString(str, i, i); //assuming if palindrome is of odd length
            int len2 = expandString(str, i, i+1); //assuming if palindrome is of even length

            int len = Math.max(len1,len2);

            if(len > (end - start)){
                start = i - (len-1)/2 ;
                end = i + (len/2);
            }
        }

        return str.substring(start,end + 1);
    }

    public int expandString(String str, int left, int right){
        while (left>=0 && right<str.length() && str.charAt(left)==str.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }

}
