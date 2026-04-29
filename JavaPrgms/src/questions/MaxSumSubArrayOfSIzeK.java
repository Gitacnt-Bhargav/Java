package questions;

public class MaxSumSubArrayOfSIzeK {

//    Geeks for Geeks
/*
Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
Note: A subarray is a contiguous part of any given array.

Examples:
Input: arr[] = [100, 200, 300, 400], k = 2
Output: 700
Explanation: arr2 + arr3 = 700, which is maximum.
Input: arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
Output: 39
Explanation: arr1 + arr2 + arr3 + arr4 = 39, which is maximum.
Input: arr[] = [100, 200, 300, 400], k = 1
Output: 400
Explanation: arr3 = 400, which is maximum.

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 106
1 ≤ k ≤ arr.size()
 */

    public static void main(String[] args) {

        // soln: since its asked for continuous sub array, we would rule out 2pointer and we are left with sliding window, prefix sum and kadane's algo
        // kadane's algo applies only if there are negative numbers and so here its ruled out, prefix sum is for sub array summation etc and hence left with
        // sliding window

        MaxSumSubArrayOfSIzeK maxSumSubArrayOfSIzeK = new MaxSumSubArrayOfSIzeK();
//        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
//        int k = 4;

//        int[] arr = {100, 200, 300, 400};
//        int k = 2;

        int[] arr = {100, 200, 300, 400};
        int k = 1;

        int maxSum = maxSumSubArrayOfSIzeK.maxSumSubAraryOfSizeK(arr, k);
        System.out.println("MAX sum sub array of size %d is %d".formatted(k, maxSum));
    }

    public int maxSumSubAraryOfSizeK(int[] arr, int k){
        //first we will take first four elements since k = 4 - which is array size
//       we will find windowsize by adding all of them
//       next loop will be created post this where we will remove the 1st element and add 5th element
//        which will give the new window size, we will have a placeholder to keep maxwindow size as result and update
//        when current window size sum is greater than the existing one

        int windowSize = 0;
        int n= arr.length;
        for(int i=0; i<k; i++){
            windowSize+= arr[i];
        }

        int maxSum = windowSize;

        for(int j=k; j<n; j++){
            windowSize += arr[j];
            windowSize -= arr[j-k];
            maxSum = Math.max(maxSum, windowSize);
        }

        return maxSum;
    }
}
