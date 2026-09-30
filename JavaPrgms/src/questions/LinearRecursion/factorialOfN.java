package questions.LinearRecursion;

public class factorialOfN {

    //  Geeks for geeks - https://www.geeksforgeeks.org/problems/factorial5739/1 - Easy

/*
Given a positive integer, n. Find the factorial of n.

Examples :
Input: n = 5
Output: 120
Explanation: 1 x 2 x 3 x 4 x 5 = 120

Input: n = 4
Output: 24
Explanation: 1 x 2 x 3 x 4 = 24
Constraints:

0 ≤ n ≤ 12
*/

    public static void main(String[] args) {
        factorialOfN fact = new factorialOfN();
        int n = 4;
        System.out.println(fact.factorial(n));
    }

    int factorial(int n) {
        if(n==0 || n==1){
            return 1;
        }

        return n*factorial(n-1);
    }

}
