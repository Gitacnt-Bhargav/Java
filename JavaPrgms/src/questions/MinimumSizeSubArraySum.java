package questions;

public class MinimumSizeSubArraySum {

//    Leet code - 209 - Medium

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:
1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

    public static void main(String[] args) {
        MinimumSizeSubArraySum minimumSizeSubArraySum = new MinimumSizeSubArraySum();
//        int[] nums = {1,4,4};
//        int target = 4;

        int[] nums = {2,3,1,2,4,3};
        int target = 7;

        int minSize = minimumSizeSubArraySum.minSizeSubArraySum(nums, target);
        System.out.println(minSize);
    }

    public int minSizeSubArraySum(int[] nums, int target){
        int minSize =Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right<nums.length; right++){

            sum += nums[right];
            while(sum>=target){
                minSize = Math.min(minSize,right - left+1);
                sum -= nums[left];
                left++;
            }
        }

        if(minSize==Integer.MAX_VALUE) return 0;
        return minSize;
    }
}
