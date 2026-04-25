package questions;


import java.util.Arrays;

public class MoveZeroes_RB {

//    Leet code: Easy - 283
//    Move zeroes to end of Array
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 10^4 -> this means that Brute force method until O(n^2) can work here
-2^31 <= nums[i] <= 2^31 - 1 ->

Follow up: Minimize total number of operations done? -> means to optimize the code
 */

    public static void main(String[] args) {

        /* solution:
        Use 2 pointer technique where left pointer would take care of all non zero values and right pointer would traverse through
        each element and only gets if that element is zero or not. If not zero - swap with element pointed by left pointer
        if zero - do nothing, go to next element

         */

        int input[] = {0,1,0,3,12};
        int left = 0;
        int temp = 0;
        for (int right = 0; right < input.length; right++){
            if(input[right]!=0){
                temp = input[right];
                input[right] = input[left];
                input[left] = temp;
                left ++;
            }
        }

        System.out.println(Arrays.toString(input));

    }

}
