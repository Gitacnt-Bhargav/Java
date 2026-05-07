package questions;

import java.util.Arrays;

public class matrixSum2DPrefixSum {

//    Leet code - 1314 - Medium

/*
Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
i - k <= r <= i + k,
j - k <= c <= j + k, and
(r, c) is a valid position in the matrix.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

Example 2:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]
Constraints:

m == mat.length
n == mat[i].length
1 <= m, n, k <= 100
*/

    public static void main(String[] args) {
        matrixSum2DPrefixSum matrixSum2DPrefixSum = new matrixSum2DPrefixSum();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;

        int[][] answer =  matrixSum2DPrefixSum.matrixSum(mat, k);
        System.out.println(Arrays.deepToString(answer));
    }

    public int[][] matrixSum(int[][] mat, int k){
        int m = mat.length;
        int n = mat[0].length;

        int[][] prefix = new int[m+1][n+1];

        for(int i = 1; i<=m; i++){
            for(int j =1; j<=n; j++){
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        System.out.println(Arrays.deepToString(prefix));

        int[][] answer = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int r1 = Math.max(0,i-k);
                int c1 = Math.max(0, j-k);

                int r2 = Math.min(m-1, i+k);
                int c2 = Math.min(n-1, j+k );

                r1++;
                c1++;
                r2++;
                c2++;

                answer[i][j] = prefix[r2][c2] - prefix[r1-1][c2] - prefix[r2][c1-1] + prefix[r1-1][c1-1];

            }
        }

        return answer;

    }
}
