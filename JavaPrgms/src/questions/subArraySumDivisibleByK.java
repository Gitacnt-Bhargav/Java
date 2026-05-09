package questions;

import java.util.HashMap;

public class subArraySumDivisibleByK {

//    Leet code - 974 - Medium
/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.

Example 1:
Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:
Input: nums = [5], k = 9
Output: 0

Constraints:
1 <= nums.length <= 3 * 10^4
-10^4 <= nums[i] <= 10^4
2 <= k <= 10^4
*/

    public static void main(String[] args) {
        subArraySumDivisibleByK subArraySumDivisibleByK = new subArraySumDivisibleByK();
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;

        int result = subArraySumDivisibleByK.numberOfSubArraysSumDivisibleByK(nums, k);
        System.out.println(result);
    }

    public int numberOfSubArraysSumDivisibleByK(int[] nums, int k){
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int rem = 0;
        map.put(0,1); //this is to male sure that if 0 comes up in array, then count can be taken directly rather than initializing and incrementing.
        for (int num : nums) {
            sum += num;
            rem = sum % k;
            if (rem < 0) rem += k;
            if (map.containsKey(rem)) {
                result += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
            System.out.println(map);
        }

        return result;
    }
}
