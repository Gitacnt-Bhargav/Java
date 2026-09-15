package questions.Stack_ExpressionEvaluation;

import java.util.Stack;

public class basicCalculator2 {

//    Leet code - 227 - Medium

/*
Given a string s which represents an expression, evaluate this expression and return its value.
The integer division should truncate toward zero.
You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 Example 1:
Input: s = "3+2*2"
Output: 7

Example 2:
Input: s = " 3/2 "
Output: 1

Example 3:
Input: s = " 3+5 / 2 "
Output: 5

Constraints:
1 <= s.length <= 3 * 10^5
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 2^31 - 1].
The answer is guaranteed to fit in a 32-bit integer.
*/

    public static void main(String[] args) {
        basicCalculator2 calculator = new basicCalculator2();
        String s = "3+2*2";
        System.out.println(calculator.calculate(s));
    }

    public int calculate(String s){
        Stack<Integer> st = new Stack<>();

        int n = s.length();
        char operator = '+';
        int num = 0;

        for(int i =0;i <s.length(); i++){

            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = (num * 10) + (ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == n-1 ){
                switch (operator){
                    case '+':
                        st.push(num);
                        break;
                    case '-':
                        st.push(-num);
                        break;
                    case '*':
                        st.push(st.pop()* num);
                        break;
                    case '/':
                        st.push(st.pop()/num);
                        break;
                }

                operator = ch;
                num = 0;
            }
        }

        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }

        return result;
    }
}
