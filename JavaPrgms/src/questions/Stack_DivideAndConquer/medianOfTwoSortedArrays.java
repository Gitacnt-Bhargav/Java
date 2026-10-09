package questions.Stack_DivideAndConquer;

public class medianOfTwoSortedArrays {

//    Leet code - 4 - Hard

/*

Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6
*/

    public static void main(String[] args) {
        medianOfTwoSortedArrays median = new medianOfTwoSortedArrays();
        int[] nums1 = {1,3};
        int[] nums2 = {2};

        System.out.println(median.findMedianSortedArrays(nums1,nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i =0;
        int j = 0;
        int k =0;

        int[] combined = new int[nums1.length + nums2.length];
        while(i<nums1.length && j<nums2.length){

            if(nums1[i] < nums2[j]){
                combined[k++] = nums1[i++];
            }else{
                combined[k++] = nums2[j++];
            }

        }

        while (i<nums1.length){
            combined[k++] = nums1[i++];
        }

        while (j<nums2.length){
            combined[k++] = nums2[j++];
        }

        double median = 0;
        int mid = combined.length/2;
        if(combined.length %2 ==0){
            median = (combined[mid-1] + combined[mid])/2.0;
        }else{
            median = combined[mid];
        }

        return median;
    }
}
