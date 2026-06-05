package questions.binarySearch_lowerOrUpperBound;

import java.util.Arrays;

public class findFirstAndLastPositionOfElement {
//    Leet code - 34 - Medium

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]

Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
 */

    public static void main(String[] args) {
        findFirstAndLastPositionOfElement findFirstAndLastPositionOfElement = new findFirstAndLastPositionOfElement();
        int[] nums = {5,7,7,8,8,10};
        int target = 9;
        System.out.println(Arrays.toString(findFirstAndLastPositionOfElement.getFirstAndLastPosOfTarget(nums,target)));
    }

    public int[] getFirstAndLastPosOfTarget(int[] nums, int target){
        int firstPos = firstPosOfTarget(nums, target);
        int lastPos = lastPosOfTarget(nums, target);
        return new int[]{firstPos,lastPos};
    }

    public int firstPosOfTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid;
        int ans = -1;

        while(left<=right){
            mid = left + (right-left)/2;

            if(nums[mid]==target){
                ans = mid;
                right = mid-1;
            }else if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid-1;
            }
        }

        return ans;
    }

    public int lastPosOfTarget(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int mid;
        int ans = -1;

        while(left<=right){
            mid = left + (right-left+1)/2;

            if(nums[mid]==target){
                ans = mid;
                left = mid+1;
            }else if(nums[mid]<target){
                left = mid +1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }
}
