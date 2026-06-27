package questions.BinarySearch_onAnswers;

public class splitLargestArray {
//    Leet Code - 410 - hard
/*
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
Return the minimized largest sum of the split.
A subarray is a contiguous part of the array.

Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

Example 2:
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 10^6
1 <= k <= min(50, nums.length)
*/
    public static void main(String[] args) {
        splitLargestArray splitLargestArray = new splitLargestArray();
        int[] nums = {1,2,3,4,5};
        int k = 2;
        System.out.println(splitLargestArray.minimizedLargestSum(nums, k));
    }

    public int minimizedLargestSum(int[] nums, int k){
        int low = 0;
        int high = 0;

        if(nums.length < k) return -1;

        for(int num: nums){
            low = Math.max(low, num);
            high += num;
        }

        int ans = low;
        int mid;
        while (low <= high){
            mid = low + (high - low)/2;

            if(canSplitWithinKArrays(nums, k, mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canSplitWithinKArrays(int[] nums, int k, int mid){
        int count = 1;
        int sumSubArray = 0;

        for(int num : nums){
            if(num + sumSubArray <= mid){
                sumSubArray += num;
            }else{
                count ++;
                sumSubArray = num;
            }
        }

        return count <= k;
    }
}
