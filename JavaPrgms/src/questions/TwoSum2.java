package questions;

public class TwoSum2 {

//    Leet code - Medium - 167
/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they
add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where
1 <= index1 < index2 <= numbers.length.
Return the indices of the two numbers index1 and index2, each incremented by one, as an integer array [index1, index2] of length 2.
The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


Constraints:
2 <= numbers.length <= 3 * 10^4 -> here we cannot go for O(n^2) complexity
-1000 <= numbers[i] <= 1000

numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */

    public static void main(String[] args) {

        /*
        Solution:
        1. Two pointers - whenever we need two points, starting from first index and last index. This can be used here
        2. Sliding window - We use when we want continuous sub array or continuous window. Here in this case we dont need any sub array or window. ignore this for this
        3. Prefix sum - we require this method, when we require continuous summation of subarray. here we dont need to store continuous data. So, ignore this
        4.  Kadane's algorithm - when we have a negative number in given array. here, nums arrays is in range -1000 to 1000, and so can be used. But this can be used only for continuous summation. Hence this can be ignored

        */

//       use 2 pointers
        int[] nums = {2,3,4};
        int target = 6;

//        int[] nums = {2,7,11,15};
//        int target = 9;

//        int[] nums = {-1,0};
//        int target = -1;
        TwoSum2 sum = new TwoSum2();
        int[] solution = sum.solution(nums, target);
        int left = solution[0];
        int right = solution[1];
        System.out.println(left + "," + right);

    }

    public int[] solution(int[] nums, int target){
        int left = 0, right = nums.length-1;
        while (left<right){
            if(nums[left]+nums[right]==target){
                return new int[]{++left, ++right};
            }else if(nums[left]+nums[right]<target){
                left ++;
            }else if(nums[left]+nums[right]>target){
                right --;
            }
        }
        return new int[]{-1,-1};
    }
}
