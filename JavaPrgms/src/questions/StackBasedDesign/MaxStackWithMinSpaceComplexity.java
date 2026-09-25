package questions.StackBasedDesign;

import java.util.Stack;

public class MaxStackWithMinSpaceComplexity {

    public static void main(String[] args) {
        MaxStackWithMinSpaceComplexity maxStack = new MaxStackWithMinSpaceComplexity();
        maxStack.push(2);
        maxStack.push(3);
        System.out.println(maxStack.peek());    // return 3
        maxStack.pop();
        System.out.println(maxStack.getMax()); // return 2
        maxStack.push(1);
        System.out.println(maxStack.getMax()); // return 2
    }

    Stack<Long> st;
    long maxVal;
    public MaxStackWithMinSpaceComplexity() {
        st = new Stack<>();
    }

    public void push(int x) {
        if(st.isEmpty()){
            st.push((long) x);
            maxVal = (long) x;
        }else{
            if(x > maxVal){
                st.push(2L*x - maxVal);
                maxVal = (long) x;
            }else{
                st.push((long) x);
            }
        }
    }

    public void pop() {
        if(st.isEmpty()) return;
        long top = st.pop();
        if(top > maxVal) maxVal = 2L*maxVal - top;
    }

    public int peek() {
        if(st.isEmpty()) return -1;
        long top = st.peek();
        return (top > maxVal) ? (int) maxVal : (int) top;
    }

    boolean isEmpty() {
        return st.isEmpty();
    }

    public int getMax() {
        if(st.isEmpty()) return -1;
        return (int) maxVal;
    }
}
