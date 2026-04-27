package questions;

import java.util.Arrays;

public class sortColors {

//    Leet code - Medium -75
//    using 2 pointer - DNF algorithm ( Dutch National flag Algorithm )

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300 -> this means that we can go with O(n^3) as well but based on any other specific rule set in the question
nums[i] is either 0, 1, or 2.
     */

    public static void main(String[] args) {

        sortColors sortColors = new sortColors();

        int[] colors = {2,0,2,1,1,0};

        int[] result = sortColors.sortcolors(colors);

        System.out.println(Arrays.toString(result));


    }

    public int[] sortcolors(int[] colors){

//        here we can think of three pointers, left, mid and right, where left would handle only 0s, mid would handle only 1s
//        and right would handle only 2s
//        Lets keep left stable in a loop cycle and allow mid to move and right from n-1.
//        Note: both left and middle starts from 0th index and right start from n-1

//        here m would be moving and since it handles 1, if it finds 1 - do not do anything, just move
//        if mth index has 0, then it should handover to lth index and then both move forward
//        if mth index has 2, then it should handover to rth index and reduce r behind. mth index is not increased since r can have
//        anything and we need to evaluate mth index again
        int n= colors.length;
        int l=0,m=0, r=n-1;

        while(m<=r){
            if(colors[m] == 0){
                colors[m] = colors[l];
                colors[l] = 0;
                m++;
                l++;
            }else if(colors[m] == 1){
                m++;
            }else{
                colors[m] = colors[r];
                colors[r] = 2;
                r--;
            }
        }

        return colors;

    }
}
