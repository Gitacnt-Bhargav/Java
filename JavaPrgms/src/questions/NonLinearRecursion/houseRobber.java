package questions.NonLinearRecursion;

import java.util.ArrayList;
import java.util.Arrays;

public class houseRobber {

//    Leet code - 198 - Medium

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it
will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you
can rob tonight without alerting the police.

Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 400
*/

    public static void main(String[] args) {
        houseRobber houseRobber = new houseRobber();
//        int[] nums = {2,7,9,3,1};
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};

        //114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240
        System.out.println(houseRobber.rob(nums));
    }

    public int rob(int[] nums) {

        //the technique is to solve using recursion and dp.
        //for every home, the robber has 2 options, either to rob or to skip


        //dp will store max for ith cell
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);

        return rob(nums, 0,dp);
    }

    private  int rob(int[] nums, int i, int[] dp){

        if(i >= nums.length)
            return 0;

        if(dp[i] != -1)
            return dp[i];

        int robCurrent = nums[i] + rob(nums, i +2, dp);
        int skipCurrent = rob(nums, i+1, dp);

        dp[i] =  Math.max(robCurrent,skipCurrent);

        return dp[i];

    }
}
