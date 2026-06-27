package questions.BinarySearch_onAnswers;

import java.util.Arrays;

public class allocateMinPages {
//    GFG - https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1 - Medium

/*
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an
integer k representing the number of students. The task is to allocate books to each student such that:
Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible
allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum.
Note: If it is not possible to allocate books to all students, return -1.

Examples:
Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.

Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 103
*/

    public static void main(String[] args) {
        allocateMinPages allocateMinPages = new allocateMinPages();
        int[] arr = {0,0};
        int k =2;
        System.out.println(allocateMinPages.minOfMaxPages(arr, k));
    }

//    firstly, find the max of sum of pages after dividing pages to k students and secondly, find min of all possible max's
//    got from first step
    public int minOfMaxPages(int[] arr, int k){
        int low=0, high =0;

        if (arr.length < k) return -1;

        for(int page: arr){
            low = Math.max(low, page); //in worst scenario if an array of 4 is to be distributed among 4 students, then
            //each would get (as prob statement says min 1 for each student), in that case Max would be the max of all those 4
            //which would be ans
            high += page;  //in worst scenario, if an array of 4 is to be given to only 1 student, then all 4 should be given,
            //then ans would be sum of all 4
        }


        int ans = low;
        int mid;

        while(low <= high){
            mid = low + (high - low)/2;
            if(canAllocate(arr, k, mid)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canAllocate(int[] arr, int k, int mid){
        int count = 1;
        int pageSum = 0;
        for(int page: arr){
            if(page + pageSum <= mid){
                pageSum += page;
            }else{
                count++;
                pageSum = page;
            }
        }

        return count <= k;
    }
}
