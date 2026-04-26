package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

//  Leet Code - Medium - 15

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000 -> this means 3 to 3 * 10^3 -> if you write the code in O(n^2) - then it would be 10^6 and if you write the code in O(n^3) - then it would be 10^9
-10^5 <= nums[i] <= 10^5
     */

    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();

        int[] nums = {-1,0,1,2,-1,-4};
        int k = 0;
        List<List<Integer>> result =  threeSum.results(nums,k);

        //output result
        System.out.println("result: " + result);
    }

    public List<List<Integer>> results(int[] nums, int k){
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);
        int l, r, sum;
        for(int i =0; i<n-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;

            l = i+1;
            r = n-1;

            while(l < r) {
                sum = nums[i] + nums[l] + nums[r];
                if (sum == k) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while( l<r && nums[l] == nums[l+1]) l++;
                    while( l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else if (sum < k) {
                    l++;
                } else if (sum > k) {
                    r--;
                }
            }
        }

        return res;


    }


}
