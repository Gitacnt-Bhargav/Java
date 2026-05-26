package questions.BinarySearch;

public class SearchInsertPosition {

//    Leet code - 35 - Easy
/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums contains distinct values sorted in ascending order.
-10^4 <= target <= 10^4
*/

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition  = new SearchInsertPosition();
        int[] nums = {-1,3,5,6};
        int target = 2;
        System.out.println(searchInsertPosition.insertPosition(nums,target));
    }

    public int insertPosition(int[] nums, int target){

        int left = 0;
        int right = nums.length-1;
        int mid =0 ;

        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

//        mid = (left+right)/2;
//        if(nums[mid]<=target) return mid+1;
//        else return mid;

        return left;

    }
}
