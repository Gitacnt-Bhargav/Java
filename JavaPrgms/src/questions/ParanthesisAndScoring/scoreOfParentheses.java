package questions.ParanthesisAndScoring;

import java.util.Stack;

public class scoreOfParentheses {

    //    Leet code - 856 - Medium
/*
Given a balanced parentheses string s, return the score of the string.
The score of a balanced parentheses string is based on the following rule:
"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.

Example 1:
Input: s = "()"
Output: 1

Example 2:
Input: s = "(())"
Output: 2

Example 3:
Input: s = "()()"
Output: 2

Constraints:
2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
*/

    public static void main(String[] args) {
        scoreOfParentheses scoreOfParentheses = new scoreOfParentheses();
        String s = "((()))";
        System.out.println(scoreOfParentheses.scoreOfParentheses(s));
        System.out.println(scoreOfParentheses.scoreOfParentheses_MinSpaceComplexity(s));
    }

    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0); //for storing the initial value which is used to store the previous result until previous )
        int val = 0;
        int score = 0;
        for(Character c : s.toCharArray()){
            if(c=='('){
                st.push(0);
            }else{
                val = st.pop();
                score = Math.max(val * 2, 1);
                st.push(score + st.pop());
            }
        }

        return  st.pop();
    }

    public int scoreOfParentheses_MinSpaceComplexity(String s) {

        int countOfOpeningBrackets = 0;
        int score = 0;
        for(int i =0; i<s.length(); i++){

            if(s.charAt(i)=='('){
                countOfOpeningBrackets++;
            }else{
                countOfOpeningBrackets --;
                if(s.charAt(i-1)=='('){
                    score += 1<<countOfOpeningBrackets;  //shift left operator (which actually multiples by 2 -> 001 << will be 010 and again << wil be 100
                }
            }
        }
        return score;
    }


}
