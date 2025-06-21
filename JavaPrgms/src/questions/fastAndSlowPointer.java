package questions;

import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class fastAndSlowPointer {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        fastAndSlowPointer fs = new fastAndSlowPointer();
        List<Integer> a = Arrays.asList(1,2,3,2,3);

        ListNode head = new ListNode(3);
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(3);
        ListNode third= new ListNode(3);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = head; //this line will decide if output should be true or false. if this is not present or commented, then we would get false, since the cycle is not formed otherwise cycle is formed
        System.out.println(fs.hasCycle(head));

        System.out.println(fs.hasCycle(linkedList.convertListWithCycle(Arrays.asList(1,2,3,2),1)));

        System.out.println(linkedList.getNthNode(linkedList.convertListWithCycle(Arrays.asList(1,2,2,3),2),3).val);
    }

    public class linkedList{
        public static ListNode convertListWithCycle(List<Integer> nums, int pos){

            ListNode head = new ListNode(nums.get(0));
            ListNode current = head;
            ListNode cycleStart = null;

            for(int i =1; i<nums.size()-1; i++){
                ListNode newNode = new ListNode(nums.get(i));
                current.next = newNode;
                current = newNode;

                if(pos==i){
                    cycleStart = newNode;
                }
            }

            if(pos==0){
                cycleStart = head;
            }

            if (pos != -1){
                current.next = cycleStart;
            }

            return  head;
        }


        public static ListNode getNthNode(ListNode head,int n){
            ListNode current = head;

            int count = 1;
            while(current!=null && count<n){
                current = current.next;
                count++;
            }

            return  current;
        }
    }


}
