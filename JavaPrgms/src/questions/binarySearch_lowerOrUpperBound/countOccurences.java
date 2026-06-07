package questions.binarySearch_lowerOrUpperBound;

public class countOccurences {
//    GFG - https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1 - Easy
/*
Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[].

Examples :
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.
Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
1 ≤ target ≤ 10^6
*/
    public static void main(String[] args) {
        countOccurences countOccurences = new countOccurences();
        int[] nums = {1, 1, 2, 2, 2, 2, 3};
        int target = 3;
        System.out.println(countOccurences.countOfOccurences(nums, target));
    }

    public int countOfOccurences(int[] nums, int target){

        int firstOccurence = firstOccurence(nums, target);
        if(firstOccurence == -1) return 0;
        int lastOccurence = lastOccurence(nums, target);
        return lastOccurence - firstOccurence +1;

    }

    public int firstOccurence(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        int mid;
        while(left<=right){
            mid = left + (right-left)/2;

            if(nums[mid] == target){
                ans = mid;
                right = mid -1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return ans;
    }

    public int lastOccurence(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        int mid;
        while(left<=right){
            mid = left + (right-left)/2;

            if(nums[mid] == target){
                ans = mid;
                left = mid +1;
            }else if(nums[mid] < target){
                left = mid +1;
            }else{
                right = mid -1;
            }
        }

        return ans;
    }
}
