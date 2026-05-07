package questions;

import java.util.Arrays;

public class productOfArrayExceptItself {

// Leet code - 238 - Medium
/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]


Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.


Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
*/

    public static void main(String[] args) {
        productOfArrayExceptItself productOfArrayExceptItself = new productOfArrayExceptItself();
//        int[] nums = {1,2,3,4};
        int[] nums = {-1,1,0,-3,3};

        int[] result = productOfArrayExceptItself.productOfArrayExceptItselfNum(nums);
        System.out.println(Arrays.toString(result));
    }

    public int[] productOfArrayExceptItselfNum(int[] nums){
        //this can be used by product of both left product and right product
        //first lets find left product

        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i =1 ; i<nums.length; i++){
            result[i] = nums[i-1] * result[i-1];
        }
//1 2 3 4 -> 1 1 2 6
        int rightProduct = 1;
//1 1 2 6
        for(int i=nums.length-2; i>=0; i-- ){
            rightProduct = rightProduct*nums[i+1];
            result[i] = result[i] * rightProduct;
        }

        return result;
    }
}
