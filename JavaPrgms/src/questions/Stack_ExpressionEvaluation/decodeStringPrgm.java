package questions.Stack_ExpressionEvaluation;

import java.util.Stack;

public class decodeStringPrgm {

//    Leet code - 394 - Medium

/*
Given an encoded string, return its decoded string.
The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
The test cases are generated so that the length of the output will never exceed 10^5.

Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"


Constraints:
1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
*/
    public static void main(String[] args) {
        decodeStringPrgm decodeStr = new decodeStringPrgm();
        String s = "3[a]2[bc]";
        System.out.println(decodeStr.decodeString1(s));
    }

    public String decodeString(String s){
        Stack<Character> stack = new Stack<>();

        StringBuilder num = new StringBuilder();
        StringBuilder str = new StringBuilder();
        StringBuilder repeated = new StringBuilder();
        for(Character ch: s.toCharArray()){
            if(ch!=']'){
                stack.push(ch);
            }else{
                //storing characters
                while(stack.peek()!='['){
                    str.insert(0,stack.pop());
                }

                    //popping out [
                stack.pop();

                //storing integers
                while(!stack.empty() && Character.isDigit(stack.peek())){
                    num.insert(0,stack.pop());
                }

                int repeat = Integer.parseInt(num.toString());

                for(int i = 0; i<repeat;i++){
                    repeated.append(str);
                }

                for(char c : repeated.toString().toCharArray()){
                    stack.push(c);
                }


                str.setLength(0);
                num.setLength(0);
                repeated.setLength(0);

            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0,stack.pop());
        }

        return result.toString();
    }

    public String decodeString1(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
