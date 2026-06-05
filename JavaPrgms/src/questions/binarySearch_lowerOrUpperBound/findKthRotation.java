package questions.binarySearch_lowerOrUpperBound;

import java.util.Arrays;

public class findKthRotation {
//    Leet code - Easy - 189

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 105
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 105
*/

    public static void main(String[] args) {
        findKthRotation findKthRotation = new findKthRotation();
        int[] nums = {-1};
        int k = 2;
        System.out.println(Arrays.toString(findKthRotation.kthRotation_method2(nums, k)));
    }

    //O(2n) time and space complexity is O(n)
    public int[] kthRotation_method1(int[] nums, int k){
        k = k%nums.length;
        int[] temp = nums.clone();
        for(int i=0; i<nums.length; i++){
            nums[(i + k)%nums.length] = temp[i];
        }
        return nums;
    }

    //O(2n) time complexity and space complexity is O(1)
    public int[] kthRotation_method2(int[] nums, int k){
        int n = nums.length;
        if( k > n){
            k = k % n;
        }
        nums = reverseArray(nums, 0, n-1);
        nums = reverseArray(nums, 0, k-1);
        nums = reverseArray(nums, k, n-1);
        return nums;
    }

    public int[] reverseArray(int[] nums, int startPos, int lastPos){
        int left = startPos;
        int right = lastPos;
        int temp;
        while(left < right){
            temp =  nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        return nums;
    }
}
