package questions.Stack_StackAndGreedy;

import java.util.Stack;

public class minRemoveToMakeValidParanthesis {

//    Leet code - 1249 - Medium

/*

Given a string s of '(' , ')' and lowercase English characters.
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:
It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Example 1:
Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.

Example 2:
Input: s = "a)b(c)d"
Output: "ab(c)d"

Example 3:
Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Constraints:
1 <= s.length <= 105
s[i] is either '(' , ')', or lowercase English letter.

*/

    public static void main(String[] args) {
        minRemoveToMakeValidParanthesis minRemoveToMakeValidParanthesis = new minRemoveToMakeValidParanthesis();
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValidParanthesis.minRemoveToMakeValid(s));
        System.out.println(minRemoveToMakeValidParanthesis.minRemoveToMakeValid_spaceOptimized(s));
    }


    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] arr = s.toCharArray();

        for(int i=0; i<s.length(); i++) {
            if (arr[i] == '(') {
                stack.push(i);
            } else if (arr[i] == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    arr[i] = '#';
                }
            }
        }

        while(!stack.isEmpty()){
            arr[stack.pop()]='#';
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch: arr){
            if(ch!='#')
                sb.append(ch);
        }

        return sb.toString();
    }


    public String minRemoveToMakeValid_spaceOptimized(String s) {
        int open = 0;
        char[] arr = s.toCharArray();
        StringBuilder first = new StringBuilder();

        //from start deal with additional ) and remove them, have it stored in first string builder. On this string builder, additional ( will be removed later
        for(Character ch : arr){
            if(ch=='(') {
                open++;
                first.append(ch);
            }
            else if(ch==')'){
                if(open >0) {
                    first.append(ch);
                    open--;
                }
            }else
                first.append(ch);
        }

        //now start reverse on the first string builder to remove additional (
        StringBuilder ans = new StringBuilder();
        int close = 0;
        for(int i=first.length()-1; i>=0; i--){
            char ch = first.charAt(i);

            if(ch==')'){
                close++;
                ans.append(ch);
            }else if(ch=='('){
                if(close > 0){
                    ans.append(ch);
                    close--;
                }
            }else{
                ans.append(ch);
            }
        }

        return ans.reverse().toString();
    }
}
