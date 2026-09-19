package questions.ParanthesisAndScoring;

import java.util.Stack;

public class minAddToMakeParenthesisValid {

    //    Leet code - 921 - Medium

/*
A parentheses string is valid if and only if:

It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:
Input: s = "())"
Output: 1

Example 2:
Input: s = "((("
Output: 3

Constraints:
1 <= s.length <= 1000
s[i] is either '(' or ')'.
*/

    public static void main(String[] args) {
        minAddToMakeParenthesisValid minAddToMakeParenthesisValid = new minAddToMakeParenthesisValid();
        String s = "(((";
        System.out.println(minAddToMakeParenthesisValid.minAddToMakeValid(s));
        System.out.println(minAddToMakeParenthesisValid.minAddToMakeValid_withoutAdditionalSpaceComplexity(s));
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int closing = 0;
        for(Character c: s.toCharArray()){
            if(c=='('){
                st.push(c);
            }else{
                if(!st.isEmpty())
                    st.pop(); //pop when there is a corresponding closing bracket else go and increment closing variable, which means there are additional closing at an incorrect place
                else
                    closing++;
            }
        }

        return st.size() + closing; //st will have only invalid opening brackets and closing will have only additional closing brackets
    }

    public int minAddToMakeValid_withoutAdditionalSpaceComplexity(String s) {
        int closing = 0;
        int opening = 0;
        for(Character c: s.toCharArray()){
            if(c=='('){
                opening ++;
            }else{
                if(opening > 0)
                    opening --; //pop when there is a corresponding closing bracket else go and increment closing variable, which means there are additional closing
                else
                    closing++;
            }
        }

        return opening + closing; //st will have only invalid opening brackets and closing will have only additional closing brackets
    }
}
