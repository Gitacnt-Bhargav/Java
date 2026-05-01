package questions;

public class MaxConsecutiveOnes111 {

// Leet code - 1004
/*
Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.


Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Constraints:
1 <= nums.length <= 10^5 -> can use only O(n)
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */

    public static void main(String[] args) {
        MaxConsecutiveOnes111 maxConsecutiveOnes111 = new MaxConsecutiveOnes111();

        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;

        int maxOnes = maxConsecutiveOnes111.MaxConsecutiveOnes3(nums, k);
        System.out.println(maxOnes);

        int maxOnes_1 = maxConsecutiveOnes111.MaxConsecutiveOnes3_1(nums, k);
        System.out.println(maxOnes_1);
    }

    /*
    there are two solutions given below. the first one uses internal while loop to move left pointer and other one uses
    if loop to move left pointer. in first case time complexity was O(2n) while in second case time complexity is O(n)

    Reason is: in first case, where while was given, we are stopping right pointer to move until zerocount <=k. So,
    right pointer moves forward in different timings and left pointer moves at different times, but both touch each
    element once only. Hence O(2n).

    In second case, where if is used, we are not stopping right pointer, instead we are reducing count if left is 0
    and we are moving right at same time. So time complexity would be O(n) since, as soon right pointer reaches last
    element, it would end. Both move at same time here.
     */
    public int MaxConsecutiveOnes3(int[] nums, int k){
        int n = nums.length;

        int left = 0;
        int zerocount =0;
        int maxOnesWithK = 0;
        for(int right = 0; right<n; right++){

            if(nums[right]==0){
                zerocount++;
            }

            while(zerocount > k){
                if(nums[left]==0){
                    zerocount--;
                }
                left ++;
            }

            maxOnesWithK = Math.max(maxOnesWithK, right - left + 1);
        }

        return maxOnesWithK;
    }

    public int MaxConsecutiveOnes3_1(int[] nums, int k){
        int n = nums.length;

        int left = 0;
        int zerocount =0;
        for(int right = 0; right<n; right++){

            if(nums[right]==0){
                zerocount++;
            }

            if(zerocount > k){
                if(nums[left]==0){
                    zerocount--;
                }
                left ++;
            }
        }

        return n - left;
    }
}
