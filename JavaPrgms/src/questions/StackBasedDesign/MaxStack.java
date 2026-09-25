package questions.StackBasedDesign;

import java.util.Stack;

public class MaxStack {

//  Geeks for Geeks - https://www.geeksforgeeks.org/problems/get-max-from-stack/1

/*
Implement a class SpecialStack that supports following operations:

push(x) – Insert an integer x onto the stack.
pop() – Remove the top element from the stack.
peek() – Return the top element from the stack. If the stack is empty, return -1.
getMax() – Retrieve the maximum element from the stack in O(1) time. If the stack is empty, return -1.
isEmpty() –  Return true if stack is empty, else false
There will be a sequence of queries queries[][]. The queries are represented in numeric form:

1 x : Call push(x)
2:  Call pop()
3: Call peek()
4: Call getMax()
5: Call isEmpty()
The driver code will process the queries, call the corresponding functions, and print the outputs of peek(), getMax(), isEmpty() operations.
You only need to implement the above five functions.

Examples:

Input: q = 7, queries[][] = [[1, 2], [1, 3], [3], [2], [4], [1, 1], [4]]
Output: [3, 2, 2]
Explanation: Queries on stack are as follows:
push(2) into the Stack
push(3) into the Stack
return top of the stack, i.e 3
remove the element 3 from the top of the stack
return maximum element from the stack i.e 2
push(1) into the stack
return maximum element from the stack i.e 2
Input: q = 5, queries[][] = [[1, 4], [1, 2], [4], [3], [5]]
Output: [4, 2, false]
Explanation: Queries on stack are as follows:
push(4) into the Stack
push(2) into the Stack
return maximum element from the stack i.e 4
return top of the stack, i.e 2
stack is non-empty, i.e. return false.

Constraints:
1 ≤ queries.size() ≤ 10^5
0 ≤ values on the stack ≤ 10^9
*/

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(2);
        maxStack.push(3);
        System.out.println(maxStack.peek());    // return 3
        maxStack.pop();
        System.out.println(maxStack.getMax()); // return -3
        maxStack.push(1);
        System.out.println(maxStack.getMax()); // return -2
    }

    Stack<Integer> st;
    Stack<Integer> maxSt;
    public MaxStack() {
        st = new Stack<>();
        maxSt = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        if(maxSt.isEmpty()) maxSt.push(x);
        else maxSt.push(Math.max(x, maxSt.peek()));
    }

    public void pop() {
        if(st.isEmpty()) return;
        st.pop();
        maxSt.pop();
    }

    public int peek() {
        if(st.isEmpty()) return -1;
        return st.peek();
    }

    boolean isEmpty() {
        return st.isEmpty();
    }

    public int getMax() {
        if(maxSt.isEmpty()) return -1;
        return maxSt.peek();
    }
}
