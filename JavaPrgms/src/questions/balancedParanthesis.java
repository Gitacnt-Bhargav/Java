package questions;

import java.util.Stack;

public class balancedParanthesis {

    public static void main(String[] args){

        String str = "[{{}}]";

        Stack<Character> st = new Stack<>();

        for(char ch: str.toCharArray()){
            if(partOfOpeningBracket(ch)){
                st.push(ch);
            }else if(partOfClosingBracket(ch)){
                if(ch=='}' && st.peek()=='{') st.pop();
                else if(ch==')' && st.peek()=='(') st.pop();
                else if(ch==']' && st.peek()=='[') st.pop();
                else {System.out.println("Not a balanced paranthesis. missing closing for " + st.peek()); break;}
            }
        }

        if(st.empty()) System.out.println("Is a Balanced paranthesis string");
    }

    private static Boolean partOfOpeningBracket(Character ch){
        if(ch=='{'||ch=='['||ch=='(') return true;
        return false;
    }

    private static Boolean partOfClosingBracket(Character ch){
        if(ch=='}'||ch==']'||ch==')') return true;
        return false;
    }
}
