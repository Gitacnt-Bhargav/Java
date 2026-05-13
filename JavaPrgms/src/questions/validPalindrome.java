package questions;

public class validPalindrome {

//    Leet code - 125 - Easy
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing
all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

    public static void main(String[] args) {
        validPalindrome validPalindrome = new validPalindrome();
//        String str = "A man, a plan, a canal: Panama";
        String str = "race a car";
        boolean result =  validPalindrome.checkValidPalindrome(str);
        System.out.println(result);
    }

    public Boolean checkValidPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        char leftChar, rightChar;
        while (left<right){
             leftChar = str.charAt(left);
             rightChar = str.charAt(right);

             if(!Character.isLetterOrDigit(leftChar)) left ++;
             else if(!Character.isLetterOrDigit(rightChar)) right--;

             else if(Character.toLowerCase(leftChar)!=Character.toLowerCase(rightChar)) return false;
             else {
                 left++;
                 right--;
             }
        }

        return true;
    }

}
