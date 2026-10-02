package questions.LinearRecursion;

public class powerOfXtoN {

//    Leet code - 50 - Medium

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).

Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000

Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100

Example 3:
Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
n is an integer.
Either x is not zero or n > 0.
-10^4 <= xn <= 10^4
*/

    public static void main(String[] args) {
        powerOfXtoN power = new powerOfXtoN();
        double x = 2.100;
        int n = 3;
        System.out.println(power.myPow(x,n));
        System.out.println(power.myPow1(x,n));
    }

    public double myPow(double x, int n) {

        double ans = 1;

        long exp = n;

        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }

        //check if exp is odd or even to multiply x with ans and then square it and then half the exp
        while(exp > 0){
            if(exp%2 !=0){
                ans *= x;
            }
            x *= x;
            exp = exp/2;
        }

        return ans;
    }

    public double myPow1(double x, int n) {

        long exp = n;
        if(exp < 0){
            x = 1/x;
            exp = -exp;
        }

        return power(x, exp, 1.0);
    }

    public double power(double x, long exp, double ans){
        //check if exp is odd or even to multiply x with ans and then square it and then half the exp
        if(exp ==0){
            return ans;
        }

        if(exp%2 !=0){
            ans *= x;
        }

        return power(x*x, exp/2, ans);
    }
}
