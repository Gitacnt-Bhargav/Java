package questions.Stack_StackSimulationOrUndoOperation;

import java.util.Stack;

public class backspaceStringCompare {

//    Leet code - 844 - Easy

/*
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Example 2:
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".

Example 3:
Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".

Constraints:
1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
Follow up: Can you solve it in O(n) time and O(1) space?

*/

    public static void main(String[] args) {
        backspaceStringCompare backspaceStringCompare = new backspaceStringCompare();
//        String s = "ab##", t = "c#d#";
        String s = "a#c", t = "b";
        System.out.println(backspaceStringCompare.backspaceCompare_1(s,t));
        System.out.println(backspaceStringCompare.backspaceCompare(s,t));
    }

    public boolean backspaceCompare_1(String s, String t) {
        return backspaceString(s).equals(backspaceString(t));
    }

    private String backspaceString(String s){
        Stack<Character> st = new Stack<>();

        for(Character c: s.toCharArray()){
            if(c=='#'){
                if(!st.isEmpty()) st.pop();
            }else
                st.push(c);
        }

        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }

        return str.toString();
    }

    public boolean backspaceCompare(String s, String t){
        int i = s.length()-1;
        int j = t.length()-1;

        int skipS = 0, skipT = 0;

        while (i>=0 || j>=0){
            while(i>=0){
                if(s.charAt(i)=='#'){
                    skipS++;
                    i--;
                }else if(skipS>0){
                        skipS--;
                        i--;
                }else
                    break; //stop at a char to match that char
            }

            while(j>=0){
                if(t.charAt(j)=='#'){
                    skipT++;
                    j--;
                }else if(skipT>0){
                    skipT--;
                    j--;
                }else
                    break; //stop at a char to match that char
            }

            if(i>=0 && j>=0){ //if both indexes are valid
                if(s.charAt(i) != t.charAt(j)) return false;
            }else{
                if(i>=0 || j>=0) return false;
                //if above if statement fails, it means i and j are not >0 and here if we are checking if either i or j are not equal
                // then it means they are not of equal string post backspace chars exclusion
            }

            i--;
            j--;

            System.out.println(i + " - " +  j);
        }

        return true;
    }
}
