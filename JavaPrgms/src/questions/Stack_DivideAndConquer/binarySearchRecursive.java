package questions.Stack_DivideAndConquer;

public class binarySearchRecursive {

//    Leet code - 704 - Easy

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All the integers in nums are unique.
nums is sorted in ascending order.
*/

    public static void main(String[] args) {
        binarySearchRecursive binarySearch = new binarySearchRecursive();
        int[] nums = {-1,0,3,5,9,12};
        int target = 4;
        System.out.println(binarySearch.search(nums, target));
    }

    public int search(int[] nums, int target){
        return searhRecursive(nums, 0, nums.length-1, target);
    }

    public int searhRecursive(int[] nums, int left, int right, int target){

        if(left > right) return -1;

        int mid = left + (right-left)/2;

        if(nums[mid] == target) return mid;

        if(nums[mid] < target) return searhRecursive(nums, mid+1, right, target);

        return searhRecursive(nums, left, mid-1, target);

    }
}
