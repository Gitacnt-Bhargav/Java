package questions;

import java.util.*;

public class topKElements_1 {

    public List<Integer> topKElementsMinHeap(int[] nums, int k){

        //Min Heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int num :  nums){
            priorityQueue.offer(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        return new ArrayList<>(priorityQueue);
    }

    public List<Integer> topKElementsMinHeapRev(int[] nums, int k){

        //Min Heap reversed
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int num :  nums){
            priorityQueue.offer(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        return new ArrayList<>(priorityQueue);
    }

    public static void main(String[] args){
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 2;

        topKElements_1 topKElements1 = new topKElements_1();
        List<Integer> reqElems =  topKElements1.topKElementsMinHeap(nums,k);

        System.out.println("Top k elements - min heap - max elems : ");
        reqElems.forEach(System.out::println);

        reqElems.clear();
        reqElems =  topKElements1.topKElementsMinHeapRev(nums,k);
        System.out.println("Top k elements - max heap - min elemes : ");
        reqElems.forEach(System.out::println);
    }
}
