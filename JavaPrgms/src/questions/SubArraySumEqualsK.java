package questions;

import java.util.HashMap;

public class SubArraySumEqualsK {

//    Leet code - 560 - Easy
/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:
Input: nums = [1,1,1], k = 2
Output: 2

Example 2:
Input: nums = [1,2,3], k = 3
Output: 2

Constraints:
1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107
*/
    public static void main(String[] args) {
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int[] nums = {1,1,1};
        int k = 2;
        int result = subArraySumEqualsK.SubArraySumEqualsK(nums, k);
        System.out.println(result);
    }

    public int SubArraySumEqualsK(int[] nums, int k){
        // methodology: Prefix sum
//        Logic : when we need sub arrays whose sum = k, then using prefix sum, we store sum of all numbers until that index
//        so if suppose i need to see for k = 3,
//        it means that sum of that sub array = sum all elements until that end of sub array - sum of all element until start of sub array
//        now, i want sum of all elements in sub array = k
//        sum all elements until that end of sub array - sum of all element until start of sub array = k
//        so i need to check if sum all elements until that end of sub array - k is already existing then it means that i can
//        include that count as well

        /*
        Think of the beads in two parts:
Part A: The beads from the very beginning up to some middle point.
Part B: The beads from that middle point up to where you are right now.
If you add Part A + Part B, you get the Total (Current Prefix Sum).
We want Part B to equal K. So, the equation looks like this:
{Part A} + K = {Current Prefix Sum}
If we do a little bit of "math magic" and move the $K$ to the other side, it looks like this:
{Part A} = {Current Prefix Sum} - K

In Short:

We subtract K from our current total to see what the total "used to be" before we added the most recent beads.
If we've seen that old total before, we've found a sub-array that equals K.
         */

        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        for(int num: nums){
            prefixSum += num;
            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}
