package questions.Stack_monotonicStack;

import java.util.Stack;

public class histogramMaxRectangleArea {

//    Leet code - 84 - Hard

/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 10^5
0 <= heights[i] <= 10^4
 */

    public static void main(String[] args) {
        histogramMaxRectangleArea maxRectangleArea = new histogramMaxRectangleArea();
        int[] heights = {2,1,5,6,2,3};
        System.out.println(maxRectangleArea.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i=0; i<=length; i++){
            int h = i == length ? 0 : heights[i]; //this to add 0 at last after our last height

            while (!st.empty() && h<heights[st.peek()]){
                int height = heights[st.pop()];
                int width = (st.empty()) ? i : i - st.peek() -1;

                int area = height * width;
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }
        return maxArea;
    }
}
