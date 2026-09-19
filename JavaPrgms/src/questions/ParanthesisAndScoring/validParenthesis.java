package questions.ParanthesisAndScoring;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class validParenthesis {

//    Leet code - 20 - Valid Parenthesis

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([])"
Output: true

Example 5:
Input: s = "([)]"
Output: false

Constraints:
1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'.

*/

    public static void main(String[] args) {
        validParenthesis validParenthesis = new validParenthesis();
        String s = "()[]{}";
        System.out.println(validParenthesis.isValid(s));
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put(')','(');
        mp.put(']','[');
        mp.put('}','{');

        for(Character c: s.toCharArray()){
            if(mp.containsKey(c)){
                if(st.isEmpty() || mp.get(c)!=st.pop()){
                    return false;
                }
            }else
                st.push(c);
        }

        return st.isEmpty();
    }
}
