package questions.StackBasedDesign;

import java.util.Stack;

public class MinStack {

//    Leet code - 155 - Medium

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int value) pushes the element value onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:
-2^31 <= val <= 2^31 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 10^4 calls will be made to push, pop, top, and getMin.
*/


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2

    }

    Stack<Integer> st;
    Stack<Integer> minSt;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }

    public void push(int value) {
        st.push(value);
        if(minSt.isEmpty())
            minSt.push(value);
        else
            minSt.push(Math.min(value,minSt.peek()));
    }

    public void pop() {
        if(!st.isEmpty()) {
            st.pop();
            minSt.pop();
        }
    }

    public int top(){
        if(st.isEmpty())
            return -1;
        return st.peek();
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    public int getMin() {
        if(minSt.isEmpty()) return -1;
        return minSt.peek();
    }
}
