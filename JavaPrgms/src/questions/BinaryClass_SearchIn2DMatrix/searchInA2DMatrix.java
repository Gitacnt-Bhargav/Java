package questions.BinaryClass_SearchIn2DMatrix;

public class searchInA2DMatrix {

// Leet code - 74 - Medium

/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.

Example 1:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true

Example 2:
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
*/
    public static void main(String[] args) {
        searchInA2DMatrix searchInA2DMatrix = new searchInA2DMatrix();
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] matrix = {{1},{3}};
        int target = 3;
        System.out.println(searchInA2DMatrix.targetPresentIn2DMatrix(matrix, target));
    }

    public boolean targetPresentIn2DMatrix(int[][] matrix, int target){
        int m = matrix.length;
        int n = matrix[0].length;
        if(target<matrix[0][0] || target>matrix[m-1][n-1]) return false;

        int top = 0;
        int bottom = matrix.length-1;
        int mid;
        int row = -1;
        while(top<=bottom){
            mid = top + (bottom-top)/2;

            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]){
                row = mid;
                break;
            }else if(target<matrix[mid][0]){
                bottom = mid - 1;
            }else{
                top = mid + 1;
            }
        }

        if(row ==-1) return false;

        //now we have got row, check on column now

        int left = 0;
        int right = n-1;

        while(left <= right){
            mid = left + (right-left)/2;
            if(target==matrix[row][mid]){
                return true;
            }else if(target<matrix[row][mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return false;

    }
}
