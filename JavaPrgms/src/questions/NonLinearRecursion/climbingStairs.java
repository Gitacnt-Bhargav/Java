package questions.NonLinearRecursion;

public class climbingStairs {
//    Leet code - 70 - Easy

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
*/

    //the number ways as the stairs increases also increases in fibonacci format for this scenario

    public static void main(String[] args) {
        climbingStairs climbingStairs = new climbingStairs();
        int n = 3;
        System.out.println(climbingStairs.climbStairs(n));
    }

    public int climbStairs(int n) {
        if(n<=2) return n;
        int prev1 = 1; //starts with min 1 stairs
        int prev2 = 2; //if 2 stairs then take 1 stair at a time twice or take 2 stairs at a time once - so 2 ways
        int c ;
        for(int i=3; i<=n; i++){
            c = prev1+ prev2;
            prev1 = prev2;
            prev2 = c;
        }
        return prev2;
    }
}
