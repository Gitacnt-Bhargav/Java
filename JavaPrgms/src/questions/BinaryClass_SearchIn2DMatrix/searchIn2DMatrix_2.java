package questions.BinaryClass_SearchIn2DMatrix;

public class searchIn2DMatrix_2 {
//    Leet code - 240 - Medium

/*
Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false

Constraints:
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matrix[i][j] <= 10^9
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-10^9 <= target <= 10^9
*/

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target = 11;
        searchIn2DMatrix_2 search = new searchIn2DMatrix_2();
        System.out.println(search.searchTarget(matrix, target));
    }

    public boolean searchTarget(int[][] matrix, int target){
        //for this either start from top right or bottom left, because that will help in taking decision, since on either direction
        //bottom or left / top or right have either greater or lesser number
        int m = matrix.length;
        int n = matrix[0].length;
        if(target < matrix[0][0] || target>matrix[m-1][n-1]) return false;

        //lets start from top right and traverse to see whether number exist
        int row = 0;
        int col = n-1;

        while(row<=m-1 && col>=0){
            if(matrix[row][col]==target) return true;
            else if(target<matrix[row][col]) col--;
            else row++;
        }

        return false;
    }
}
