package questions.BinarySearch_onAnswers;

import java.util.Arrays;

public class aggressiveCows {
//    GFG - Medium - https://www.geeksforgeeks.org/problems/aggressive-cows/1
/*
You are given an array with unique elements of stalls[], which denote the positions of stalls.
You are also given an integer k which denotes the number of aggressive cows. The task is to assign stalls to k cows such that
the minimum distance between any two of them is the maximum possible.

Examples:
Input: stalls[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[2] and
the third cow can be placed at stalls[3].
The minimum distance between cows in this case is 3, which is the largest among all possible ways.

Input: stalls[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at stalls[0],
the second cow can be placed at stalls[1] and
the third cow can be placed at stalls[4].
The minimum distance between cows in this case is 4, which is the largest among all possible ways.

Input: stalls[] = [2, 12, 11, 3, 26, 7], k = 5
Output: 1
Explanation: There are 6 stalls and only 5 cows, we try to place the cows such that the minimum distance between any two cows is as
large as possible.
The minimum distance between cows in this case is 1, which is the largest among all possible ways.

Constraints:
2 ≤ stalls.size() ≤ 10^6
0 ≤ stalls[i] ≤ 10^8
2 ≤ k ≤ stalls.size()
*/
    public static void main(String[] args) {
//        int[] stalls = {2, 12, 11, 3, 26, 7};
//        int k = 5;
        int[] stalls = {10, 1, 2, 7, 5};
        int k = 3;
        aggressiveCows aggressiveCows = new aggressiveCows();
        System.out.println(aggressiveCows.minOfMaxDist(stalls, k));

    }

    public int minOfMaxDist(int[] stalls, int k){

        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1; //min gap
        int high = stalls[n-1] - stalls[0]; //max gap is the dist between max and lowest in the sorted stalls array

        int mid;
        int ans= 0;
        while (low <= high){
            mid = low + (high - low)/2;

            if(canPlaceCow(stalls, k, mid )){
                ans = mid;
                low = mid + 1; //we need max gap
            }else{
                high = mid - 1;
            }

        }

        return ans;
    }

    public boolean canPlaceCow(int[] stalls, int k, int gap){
        int last = stalls[0];
        int count =1;

        //check if all cows can be placed, the first cow is placed at 1st place in stalls, and rest placed in based on gap in sorted
        // stalls

        for(int i = 1; i<=stalls.length-1; i ++){
            if((stalls[i] - last) >= gap ){
                count ++;
                last = stalls[i];
            }
        }

        return count >= k; //make sure that all atleast k number of cows are placed

    }

}
