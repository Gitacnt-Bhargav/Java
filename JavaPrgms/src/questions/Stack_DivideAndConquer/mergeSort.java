package questions.Stack_DivideAndConquer;

import java.util.Arrays;

public class mergeSort {

//    Geeks for Geeks - https://www.geeksforgeeks.org/problems/merge-sort/1 - Medium

/*
Given an array arr[], its starting position l and its ending position r. Sort the array using the merge sort algorithm.

Examples:

Input: arr[] = [4, 1, 3, 9, 7]
Output: [1, 3, 4, 7, 9]
Explanation: We get the sorted array after using merge sort

Input: arr[] = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Explanation: We get the sorted array after using merge sort

Constraints:
1 ≤ arr.size() ≤ 10^5
0 ≤ arr[i] ≤ 10^5
*/

    public static void main(String[] args) {
        mergeSort sort = new mergeSort();
        int[] arr = {4, 1, 3, 9, 7};
        sort.mergeSort(arr,0, arr.length-1);
    }

    public void mergeSort(int arr[], int l, int r) {

        if(l >= r)
            return;

        int mid = l + (r-l)/2;

        mergeSort(arr, l, mid);

        mergeSort(arr, mid+1, r);

        merge(arr, l, mid, r);

//        System.out.println(Arrays.toString(arr));
    }

    public void merge(int[] arr, int l, int mid, int r){

        int[] temp = new int[r-l+1];

        int i =l;
        int j = mid+1;
        int k =0;

        while(i<=mid && j<=r){

            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];

            else
                temp[k++] = arr[j++];

        }

        //add remaining items
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        while(j<=r){
            temp[k++] = arr[j++];
        }

        //copy temp to arr

        for( i=0; i<temp.length; i++){
            arr[i+l] = temp[i];
        }


    }
}
