package questions.Stack_RecursiveStack;

import java.util.Stack;

public class deleteMidElementOfStack {

//    Geeks for geeks - https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1 - Easy


/*
Given a stack s, delete the middle element of the stack without using any additional data structure.
The middle element is defined as the floor(size of stack + 1) / 2)-th element from the bottom of the stack (using 1-based indexing).

Note: The output shown by the compiler is the stack from top to bottom.

Examples:

Input: s = [10, 20, 30, 40, 50]
Output: [50, 40, 20, 10]
Explanation: The bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like [10, 20, 40, 50].
Input: s = [10, 20, 30, 40]
Output: [40, 30, 10]
Explanation: The bottom-most element will be 10 and the top-most element will be 40. Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like [10, 30, 40].

Constraints:
2 ≤ s.size() ≤ 104
-106 ≤ s[i] ≤ 106
*/

//    The pattern worth remembering for recursive stack problems is:
//    POP → RECURSE → PUSH

//    And for deleting the middle:
//    POP until middle → don't push middle → PUSH everything else back

//    Every recursive method needs a base condition that eventually stops the recursion.

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);

        System.out.println(s);
        deleteMidElementOfStack deleteMidElementOfStack = new deleteMidElementOfStack();
        deleteMidElementOfStack.deleteMid(s);

        System.out.println(s);

    }

    public void deleteMid(Stack<Integer> s) {
        // code here
        int mid = (s.size()+1)/2;

        deleteMidElem(s,mid);
    }

    public void deleteMidElem(Stack<Integer> s, int mid){

        //here the delete starts from mid and once it reaches last element which is the mid element, its popped but not stored or
        //not re-inserted, once returned, all deleted from top to mid would be restored except mid.
        if(mid==1){
            s.pop();
            return;
        }
        int top = s.pop();

        deleteMidElem(s, mid-1);

        s.push(top);


    }



}
