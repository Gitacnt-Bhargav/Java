package questions;


import java.util.HashSet;

public class MaxSumDistinctSubArrayOfSizeK {

//    LeetCode - 2461 - Medium

/*
You are given an integer array nums and an integer k. Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
The length of the subarray is k, and
All the elements of the subarray are distinct.
Return the maximum subarray sum of all the subarrays that meet the conditions. If no subarray meets the conditions, return 0.
A subarray is a contiguous non-empty sequence of elements within an array.



Example 1:
Input: nums = [1,5,4,2,9,9,9], k = 3
Output: 15
Explanation: The subarrays of nums with length 3 are:
- [1,5,4] which meets the requirements and has a sum of 10.
- [5,4,2] which meets the requirements and has a sum of 11.
- [4,2,9] which meets the requirements and has a sum of 15.
- [2,9,9] which does not meet the requirements because the element 9 is repeated.
- [9,9,9] which does not meet the requirements because the element 9 is repeated.
We return 15 because it is the maximum subarray sum of all the subarrays that meet the conditions

Example 2:
Input: nums = [4,4,4], k = 3
Output: 0
Explanation: The subarrays of nums with length 3 are:
- [4,4,4] which does not meet the requirements because the element 4 is repeated.
We return 0 because no subarrays meet the conditions.


Constraints:
1 <= k <= nums.length <= 10^5 -> can go with O(n) only
1 <= nums[i] <= 10^5 -> can take int
*/

    public static void main(String[] args) {

        // soln: since its asked for continuous sub array, we would rule out 2pointer and we are left with sliding window, prefix sum and kadane's algo
        // kadane's algo applies only if there are negative numbers and so here its ruled out, prefix sum is for sub array summation etc and hence left with
        // sliding window

        MaxSumDistinctSubArrayOfSizeK maxSumSubArrayOfSizeK = new MaxSumDistinctSubArrayOfSizeK();
//        int[] nums = {1,5,4,2,9,9,9};
//        int[] nums = {4,4,4};
//        int[] nums = {1,1,1,7,8,9};
        int[] nums = {1,2,1,2,7,8,9};
        int k = 3;

        long result = maxSumSubArrayOfSizeK.maxSumSubArrayOfSizeK(nums, k);
        System.out.println(result);
    }

    public long maxSumSubArrayOfSizeK(int[] nums, int k){

        //first we will take first three elements since k = 3 - which is array size
        int n = nums.length;
        long maxSum = 0;
        int begin = 0;
        int subArraySum = 0;
        HashSet<Integer> elements = new HashSet<>();
        for(int end = 0; end<n; end++){
            if(!elements.contains(nums[end])){
                subArraySum += nums[end];
                elements.add(nums[end]);

                if(end - begin + 1 == k){
                    maxSum = Math.max(maxSum, subArraySum);
                    subArraySum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin ++;
                }
                System.out.println("Begin: " + nums[begin] + " and end is: " + nums[end]);
            }else {
                while(nums[begin] != nums[end]){
                    subArraySum -= nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        return maxSum;
    }
}
