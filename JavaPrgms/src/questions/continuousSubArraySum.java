package questions;

import java.util.Arrays;
import java.util.HashMap;

public class continuousSubArraySum {

//    Leet code - 523 - Medium
/*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
A good subarray is a subarray where:
its length is at least two, and
the sum of the elements of the subarray is a multiple of k.

Note that:
A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

Example 1:
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.

Example 2:
Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.

Example 3:
Input: nums = [23,2,6,4,7], k = 13
Output: false

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= sum(nums[i]) <= 2^31 - 1
1 <= k <= 2^31 - 1
*/

    /*
    Soln:

    Short proof and how it maps to the algorithm:
Definitions:
Let S[i] be the prefix sum up to index i (inclusive). For convenience define S[-1] = 0.
A subarray from index a to b has sum S[b] - S[a-1].
Key math:
If two prefix sums have the same remainder modulo k, i.e. S[j] % k == S[i] % k with j > i, then
S[j] - S[i] is divisible by k because (S[j] - S[i]) % k == (S[j] % k - S[i] % k) % k == 0.
That means the subarray from index i+1 to j has sum that is a multiple of k.
How the algorithm uses this:
Maintain a running prefix sum sum while iterating the array.
Compute rem = sum % k at each index.
Keep a map from remainder → earliest index where that remainder appeared.
If you see the same rem again at index j, then the subarray from map.get(rem)+1 to j sums to a multiple of k.
To satisfy the problem constraint (subarray length ≥ 2), require j - map.get(rem) >= 2 before returning true.
Important implementation details:
Initialize the map with map.put(0, -1) so a subarray starting at index 0 is detected (because S[j] % k == 0 gives j - (-1) >= 2 check).
Store the earliest index for each remainder (do not overwrite). Earliest index gives the maximal window and ensures you detect the smallest j - i that can meet the length constraint.
Use a wider integer type (e.g. long) for sum to avoid overflow when sums can be large.
Special-case k == 0: modulo is invalid; instead check for at least two consecutive zeros (their sum is 0).
If negative numbers are possible, normalize remainders to nonnegative (e.g. (sum % k + k) % k), though with nonnegative inputs this isn’t needed.
Quick example:
nums = [23, 2, 4, 6, 7], k = 6
Prefix sums: 23, 25, 29, 35, 42
Remainders % 6: 5, 1, 5, 5, 0 — remainder 5 repeats (indices 0 and 2) → subarray (1..2) sum = 6 → valid.
nums = [23, 2, 6, 4, 7], k = 13
Prefix sums: 23, 25, 31, 35, 42
Remainders % 13: 10, 12, 5, 9, 3 — no repeats → no qualifying subarray.
     */

    public static void main(String[] args) {
        continuousSubArraySum continuousSubArraySum = new continuousSubArraySum();
//        int[] nums = {23,2,4,6,7};
//        int k = 6;
        int[] nums = {23,2,6,4,7};
        int k = 13;

        boolean result =   continuousSubArraySum.contSubArraySum(nums, k);
        System.out.println(result);

    }

    public boolean contSubArraySum(int[] nums, int k){
        boolean result = false;

        if (nums == null || nums.length < 2) return false;

        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0 && nums[i + 1] == 0) return true;
            }
            return false;
        }

        //Prefix and modulus with k
        int[] arr = new int[nums.length];
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum += nums[i];
            arr[i] = sum%k;
        }

        System.out.println(Arrays.toString(arr));

        //this is to check if same modulus number is repeating. if repeating then check if their gap is >=2 and if both conditions satisfies, then it means that in between
//      those indexes we have a subarray whose sum is multiple of k
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i =0; i<nums.length; i++){
            if(map.containsKey(arr[i])){
                if(i-map.get(arr[i])>=2)
                    return true;
            }else {
                map.put(arr[i], i);
            }
        }
        System.out.println(map);
        return result;

    }


}
