package questions;

import java.util.Arrays;
import java.util.List;

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        this.val = x;
        next = null;
    }
}


public class LeetCode876_MiddleofTheLinkedList {
    public ListNode1 getMiddleOfLinkedList(ListNode1 head) {
        ListNode1 fast = head;
        ListNode1 slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LeetCode876_MiddleofTheLinkedList l = new LeetCode876_MiddleofTheLinkedList();
        List<Integer> a = Arrays.asList(1, 3, 2, 44, 2, 22, 3);

        ListNode1 middleElem = l.getMiddleOfLinkedList(linkedList1.convertListWithCycle(a, 1,false));
        //have this as 1 AND cycle flag as false, which will make pos = -1 even if we pass any value, this is to make the list not in cycle, otherwise the middle node will be recursive, since fast will be not null and fast.next wont be null since it is a cycle
        System.out.println(middleElem.val);

        StringBuilder str = new StringBuilder();
        ListNode1 head = reverseLinked(linkedList1.convertListWithCycle(a,1,false));
        while (head!=null){
            str.append(head.val).append(",");
            head = head.next;
        }
        System.out.println(str.substring(0,str.length()-1));
    }

    public class linkedList1 {
        public static ListNode1 convertListWithCycle(List<Integer> nums, int pos,boolean cycle) {

            ListNode1 head = new ListNode1(nums.get(0));
            ListNode1 current = head;
            ListNode1 cycleStart = null;

            for (int i = 1; i < nums.size() ; i++) {
                ListNode1 newNode = new ListNode1(nums.get(i));
                current.next = newNode;
                current = newNode;

                if (pos == i) {
                    cycleStart = newNode;
                }
            }

            if (pos == 0) {
                cycleStart = head;
            }

            if(!cycle) pos = -1;
            if (pos != -1) {
                current.next = cycleStart;
            }

            return head;
        }
    }

    public static ListNode1 reverseLinked(ListNode1 a){
        ListNode1 prev = null;
        ListNode1 head = a;

        while(head!=null){
            ListNode1 newNode = head.next;
            head.next = prev;
            prev = head;
            head = newNode;
        }

        return prev;
    }
}
