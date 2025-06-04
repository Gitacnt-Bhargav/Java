package questions;

import java.util.*;

public class topKFreqFoundIntegers {

    public int[] topKFreqFoundInts(int[] nums, int k){

        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : nums){
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer,Integer> mp : freqMap.entrySet()){
            priorityQueue.offer(mp);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        int i = 0;
        while(!priorityQueue.isEmpty()){
            result[i++] = priorityQueue.poll().getKey();
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,1,2,2,2,3,3,4};
        int k =2;
        topKFreqFoundIntegers topKFreqFoundIntegers = new topKFreqFoundIntegers();
        System.out.println(Arrays.toString(topKFreqFoundIntegers.topKFreqFoundInts(nums, k)));
    }
}
