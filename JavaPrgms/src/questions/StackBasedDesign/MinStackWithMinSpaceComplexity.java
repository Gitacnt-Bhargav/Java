package questions.StackBasedDesign;

import java.util.Stack;

public class MinStackWithMinSpaceComplexity {

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

    /*

                     MIN STACK
                     │
          ┌──────────┴──────────┐
          │                     │
    value >= min            value < min
          │                     │
    store normally          encode it
                              │
                    2 * value - oldMin
                              │
                         min = value


POP:
                    popped < min ?
                       /       \
                     YES        NO
                      │          │
              restore old min   do nothing
              2*min - popped
     */


    public static void main(String[] args) {
        MinStackWithMinSpaceComplexity minStack = new MinStackWithMinSpaceComplexity();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin()); // return -3
//        minStack.pop();
        System.out.println(minStack.top());    // return 0
        minStack.pop();
        System.out.println(minStack.getMin()); // return -2

    }

    Stack<Integer> st;
    int minVal;
    public MinStackWithMinSpaceComplexity() {
        st = new Stack<>();
    }

    public void push(int value) {
        if(st.isEmpty()) {
            st.push(value);
            minVal = value;
        }else if(value <minVal){
            st.push(2*value-minVal); //a new transformation before pushing into stack, so that while popping we can get to know the next minVal without storing that in a separate stack in order to reduce space complexity
            minVal = value;
        }else{
            st.push(value);
        }

    }

    public void pop() {
        if(st.isEmpty())
            return;
        int top = st.pop();
        if(top<minVal) minVal = 2*minVal - top;
    }

    public int top(){
        if(st.isEmpty())
            return -1;
        int top = st.peek();
        return (top<minVal) ? minVal : top;
    }

    public boolean isEmpty(){
        return st.isEmpty();
    }

    public int getMin() {
        return minVal;
    }

//for Long operation:
//    Stack<Long> st;
//    long minVal;
//    public MinStackWithMinSpaceComplexity() {
//        st = new Stack<>();
//    }
//
//    public void push(int value) {
//        if(st.isEmpty()) {
//            st.push((long) value);
//            minVal = (long) value;
//        }else if((long) value <minVal){
//            st.push(2L*value-minVal); //a new transformation before pushing into stack, so that while popping we can get to know the next minVal without storing that in a separate stack in order to reduce space complexity
//            minVal = (long) value;
//        }else{
//            st.push((long)value);
//        }
//
//    }
//
//    public void pop() {
//        if(st.isEmpty())
//            return;
//        long top = st.pop();
//        if(top<minVal) minVal = 2L*minVal - top;
//    }
//
//    public int top(){
//        if(st.isEmpty())
//            return -1;
//        long top = st.peek();
//        return (top<minVal) ? (int) minVal : (int) top;
//    }
//
//    public boolean isEmpty(){
//        return st.isEmpty();
//    }
//
//    public int getMin() {
//        return (int)minVal;
//    }
}
