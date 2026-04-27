package questions;

public class waterContainerWithMostWater {

//    Leetcode - Medium - 11
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 10^5 -> this means we can have only O(n) possibility to deal with this
0 <= height[i] <= 10^4 -> can use int since max of Integer is 10^9, also product of n and height, max can be 10^9 so we can go with int, otherwise we have to go with long

here, the array is not sorted but still we can use concept of 2 pointer. 2pointer needs sorted array so as to decide
which pointer of left or right to be moved. But if we can give that decision, then we can still go with 2pointer technique

Decision would be to increase the left pointer if left index is <= height in right index. Accordingly area is calculated.
*/

    public static void main(String[] args) {
        waterContainerWithMostWater container = new waterContainerWithMostWater();

        int[] heights = {1,8,6,2,5,4,8,3,7};
//        int[] heights = {1,1};

        int res = container.waterContainerWithMostWater(heights);

        System.out.println("Max: " + res);
    }

    public int waterContainerWithMostWater(int[] heights){
        int res = 0;
        int l =0, r= heights.length-1;
        int height, width, maxarea;

        while(l < r){
            height = Math.min(heights[l], heights[r]);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("l: " + l + " r: " + r);
            width = r-l;
            maxarea = height * width;
            if(heights[l]<=heights[r]){
                l++;
                while(heights[l] <= heights[l-1]) l++;
            }else{
                r--;
                while(r>0 && heights[r] <= heights[r+1]) r--;
            }
            if(res < maxarea){
                res = maxarea;
            }
            System.out.println("Max area:" + res);
        }

        return res;
    }
}
