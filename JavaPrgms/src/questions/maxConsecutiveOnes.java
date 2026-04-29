package questions;

public class maxConsecutiveOnes {

//    leet code - Easy - 485
/*
485. Max Consecutive Ones
Given a binary array nums, return the maximum number of consecutive 1's in the array.

Example 1:
Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.

Example 2:
Input: nums = [1,0,1,1,0,1]
Output: 2

Constraints:
1 <= nums.length <= 10^5 -> we have limit of 10^8 and so here we can go with O(n)
nums[i] is either 0 or 1.
*/

    public static void main(String[] args) {
//        int[] nums = {1,1,0,1,1,1};
        int[] nums = {1,0,1,1,0,1};
        int res;
        maxConsecutiveOnes maxConsecutiveOnes = new maxConsecutiveOnes();
        res = maxConsecutiveOnes.getMaxConsecutiveOnes(nums);

        System.out.println(res);
    }

    public int getMaxConsecutiveOnes(int[] nums){
        /*
            Have 2 pointers, i and j where both start at 0. Start traversing j and see if you find any 0, if you see then bring that
            i to current j position and store the value j-i in count of 1s that j took to reach 0
            Input: nums = [1,1,0,1,1,1]
        */
        int n = nums.length;
        int i=0, j=0;
        int count = 0;
        int maxCount = 0;
        while(i<n && j<n){
            while(j<n && nums[j]!=0){
                j++;
            }
            count = j-i;
            maxCount = Math.max(maxCount, count);
            i = j+1;
            j++;
        }

        return maxCount;
    }
}
