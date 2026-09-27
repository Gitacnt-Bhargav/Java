package questions;

public class removeKDigits {

//    Leet code - 402 - Medium

/*
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after
removing k digits from num.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

Constraints:
1 <= k <= num.length <= 10^5
num consists of only digits.
num does not have any leading zeros except for the zero itself.
*/

    public static void main(String[] args) {
        removeKDigits removeKDigits = new removeKDigits();
        String num = "10200";
        int k = 1;
        System.out.println(removeKDigits.removeKdigits(num, k));
    }


    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder();

        for(char ch : num.toCharArray()){
            //this is to check if prev char is greater than current, remove that prev character
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)> ch){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(ch);
        }

        //if suppose still there is a number whose chars are increasing towards right, then none of the chars will be removed
        //by above, in that case, remove last 2 chars
        sb.setLength(sb.length()-k);

        //now remove all leading zeros
        int start = 0;
        while(start < sb.length() && sb.charAt(start)=='0'){
            start++;
        }

        String ans = sb.substring(start);
        return ans.isEmpty() ? "0" : ans;
    }
}
