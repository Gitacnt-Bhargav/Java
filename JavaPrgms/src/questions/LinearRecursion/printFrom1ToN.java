package questions.LinearRecursion;

public class printFrom1ToN {

//    Geeks for geeks - https://www.geeksforgeeks.org/problems/print-1-to-n-without-using-loops3621/1 - Easy

/*

Given an positive integer n, print numbers from 1 to n without using loops.

Implement the function printTillN() to print the numbers from 1 to n as space-separated integers.

Examples
Input: n = 5
Output: 1 2 3 4 5
Explanation: We have to print numbers from 1 to 5.

Input: n = 10
Output: 1 2 3 4 5 6 7 8 9 10
Explanation: We have to print numbers from 1 to 10.
Constraints:

1 ≤ n ≤ 1000
*/

    public static void main(String[] args) {
        printFrom1ToN print = new printFrom1ToN();
        int n = 10;
        print.printTillN(n);
    }

    public void printTillN(int n) {
        int inc =1;
        printTillNFn(n, inc);
    }

    public void printTillNFn(int n,int inc){
        if(inc ==n+1) return;

        System.out.print(inc);
        System.out.print(" ");
        printTillNFn(n, inc+1);
    }
}
