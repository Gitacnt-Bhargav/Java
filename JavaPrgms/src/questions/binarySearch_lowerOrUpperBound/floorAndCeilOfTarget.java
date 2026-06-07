package questions.binarySearch_lowerOrUpperBound;

public class floorAndCeilOfTarget {
//    GFG - https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1 - Easy

/*

Given a sorted array arr[] and an integer x, find the index (0-based) of the largest element in arr[] that is less than or equal to x.
This element is called the floor of x. If such an element does not exist, return -1.

Note: In case of multiple occurrences of floor of x, return the index of the last occurrence.

Examples
Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
Output: 1
Explanation: Largest number less than or equal to 5 is 2, whose index is 1.

Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 11
Output: 4
Explanation: Largest Number less than or equal to 11 is 10, whose indices are 3 and 4. The index of last occurrence is 4.

Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 0
Output: -1
Explanation: No element less than or equal to 0 is found. So, output is -1.

Constraints:
1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i] ≤ 10^6
0 ≤ x ≤ arr[n-1]
*/

    public static void main(String[] args) {
        floorAndCeilOfTarget floorAndCeilOfTarget = new floorAndCeilOfTarget();
        int[] nums = {1, 2, 8, 10, 10, 12, 19};
        int x = 11;
        System.out.println(floorAndCeilOfTarget.floorOfTarget(nums,x));
        System.out.println(floorAndCeilOfTarget.cielOfTarget(nums,x));
    }

    public int floorOfTarget(int[] arr, int x){
        int left = 0;
        int right = arr.length -1;
        int mid;
        int ans = -1;
        while(left <= right){
            mid = left + (right-left)/2;

            if(arr[mid] <= x){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    public int cielOfTarget(int[] arr, int x){
        int left = 0;
        int right = arr.length -1;
        int mid;
        int ans = -1;
        while(left <= right){
            mid = left + (right-left)/2;

            if(arr[mid] >= x){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }


}
