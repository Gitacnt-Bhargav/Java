package questions.BinaryClass_SearchIn2DMatrix;

public class kthSmallestInSortedMatrix {

//    GFG - Medium - https://www.geeksforgeeks.org/problems/kth-element-in-matrix/1

/*
Given a matrix mat[][] of size n*n, where each row and column is sorted in non-decreasing order.
Find the kth smallest element in the matrix.

Examples:
Input: mat[][] = [[16, 28, 60, 64], k = 3
                [22, 41, 63, 91],
                [27, 50, 87, 93],
                [36, 78, 87, 94]]
Output: 27
Explanation: 27 is the 3rd smallest element.
Input: mat[][] = [[10, 20, 30, 40], k = 7
                [15, 25, 35, 45],
                [24, 29, 37, 48],
                [32, 33, 39, 50]]
Output: 30
Explanation: 30 is the 7th smallest element.
Constraints:
1 ≤ n ≤ 500
1 ≤ mat[i][j] ≤ 10^4
1 ≤ k ≤ n*n
*/

    public static void main(String[] args) {
        kthSmallestInSortedMatrix kthSmallestInSortedMatrix = new kthSmallestInSortedMatrix();
        int[][] mat = {{10,20,30,40},{15,25,35,45},{24,29,37,48},{32,33,30,50}};
        int k = 7;
        System.out.println(kthSmallestInSortedMatrix.kthSmallestNumber(mat, k));
    }

    public int kthSmallestNumber(int[][] mat, int k){
        int n = mat.length;
        if(n*n < k) return -1;

        int low = mat[0][0];
        int high = mat[n-1][n-1];
        int mid;
        while(low<=high){
            mid = low + (high - low)/2;

            if(countOfLesserNums(mat, mid) < k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public int countOfLesserNums(int[][] mat, int mid){
        int row = mat.length-1;
        int col = 0;
        int count = 0;
        while(row>=0 && col<=mat.length-1){
            if (mat[row][col] <= mid) {
                count += (row+1);
                col++;
            }else{
                row--;
            }
        }
        return count;
    }
}
