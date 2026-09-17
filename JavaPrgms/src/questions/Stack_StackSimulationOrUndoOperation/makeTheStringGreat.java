package questions.Stack_StackSimulationOrUndoOperation;

public class makeTheStringGreat {

//  Leet code - 1544 - Easy
/*
Given a string s of lower and upper case English letters.

A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
1. 0 <= i <= s.length - 2
2. s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.

Return the string after making it good. The answer is guaranteed to be unique under the given constraints.

Notice that an empty string is also good.

Example 1:
Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".

Example 2:
Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""

Example 3:
Input: s = "s"
Output: "s"

Constraints:
1 <= s.length <= 100
s contains only lower and upper case English letters.
*/

    public static void main(String[] args) {
        makeTheStringGreat makeTheStringGreat = new makeTheStringGreat();
        String s = "leEeetcode";
        System.out.println(makeTheStringGreat.makeGood(s));
    }

    public String makeGood(String s) {
        StringBuilder str = new StringBuilder();

        for(Character c: s.toCharArray()){
            int len = str.length();

            //here the condition is checked in way that case doesnt match
            if(len>0 && ((Character.isUpperCase(str.charAt(len-1)) && Character.isLowerCase(c)) || (Character.isLowerCase(str.charAt(len-1)) && Character.isUpperCase(c))) && Character.toLowerCase(str.charAt(len-1))==Character.toLowerCase(c) ){
                str.deleteCharAt(len-1);
            }else{
                str.append(c);
            }
        }

        return str.toString();
    }

    public String makeGood1(String s) {
        StringBuilder str = new StringBuilder();

        for(Character c: s.toCharArray()){
            int len = str.length();

            //here the condition is checked in way that if case is not changed, then they should not match, like c <> C
            if(len>0 && Character.toLowerCase(str.charAt(len-1))==Character.toLowerCase(c) && str.charAt(len-1) !=c){
                str.deleteCharAt(len-1);
            }else{
                str.append(c);
            }
        }

        return str.toString();
    }
}
