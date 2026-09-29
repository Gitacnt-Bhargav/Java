package questions;

import java.util.Stack;

public class reverseAStack {

//    Geeks for Geeks - https://www.geeksforgeeks.org/problems/reverse-a-stack/1 - Medium

/*
You are given a stack st[]. You have to reverse the stack.
Note: The input array represents the stack from bottom to top (last element is the top). The output is displayed by printing elements from top to bottom after reversal.

Examples:

Input: st[] = [1, 2, 3, 4]
Output: [1, 2, 3, 4]
Explanation: After reversing, the elements of stack are in opposite order.

Input: st[] = [3, 2, 1]
Output: [3, 2, 1]
Explanation: After reversing, the elements of stack are in opposite order.

Constraints:
1 ≤ st.size() ≤ 100
0 ≤ stack element ≤ 100
*/


    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        System.out.println(st);
        System.out.println(st.peek());
        reverseStack(st);

        System.out.println(st);
        System.out.println(st.peek());
    }

    //as part of recursion, call to itself is stacked in an inner stack.
    public static void reverseStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty()) return;
        int top = st.pop();
        reverseStack(st);

        insertAtBottom(st, top);
    }

    private static void insertAtBottom(Stack<Integer> st, int x){
        //if stack is empty, just push the x
        if(st.isEmpty()){
            st.push(x);
            return ;
        }

        //if stack is not empty, then store that in temp and call itself and calls to be maintained in inner stack
        int temp = st.pop();
        insertAtBottom(st, x); //with this, all elements gets popped into temp but in an internal stack based on the calls.

        //when all are popped to inner stack and our main stack is empty, it will start pushing back to stack which will be in
        //reverse manner. finally, the temp is to be loaded back.

        st.push(temp);

    }

}
