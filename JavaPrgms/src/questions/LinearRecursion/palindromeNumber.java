package questions.LinearRecursion;

public class palindromeNumber {

//    Geeks for geeks - https://www.geeksforgeeks.org/problems/palindrome0746/1 - Easy

/*
You are given an integer n. Your task is to find if it is a palindrome.

Examples:

Input: n = 555
Output: true
Explanation: The number 555 reads the same backward as forward, so it is a palindrome.

Input: n = 123
Output: false
Explanation: The number 123 reads differently backward (321), so it is not a palindrome.

Input: n = -121
Output: true
Explanation: if number is palindrome, mainly ignore sign.
Constraints:

-10^9 ≤ n ≤ 10^9

*/
//I made it all the way to the middle without finding a mismatch → palindrome → true.

    /*
    there is a very simple way to decide a recursive base condition.

The golden question

Whenever you're writing recursion, ask:

"When should I STOP making another recursive call?"

That answer is your base condition.

For your palindrome problem, ask:

"When do I no longer have anything useful to check?"

Answer:

When the left pointer reaches or crosses the right pointer.

A simple 3-step method
When solving a recursive problem, think:
1. What am I doing repeatedly?
For palindrome:
Compare left character with right character
2. When can I stop?
When I've reached the middle:
left >= right
3. What should I return when I stop?
If I reached the middle without finding a mismatch:
true
Therefore:
if (left >= right)
    return true;

A trick that works for many recursion problems
Think:
"What is the smallest/simplest case where I already know the answer?"
That is usually your base condition.

Example 1: Palindrome
"121"
Eventually:
left = 1
right = 1
There's only one character.
Obviously it's a palindrome.
Therefore:
if (left >= right)
    return true;

Example 2: Factorial
5! = 5 × 4 × 3 × 2 × 1
You keep reducing:
5
4
3
2
1
When you reach:
0
you know:
0! = 1
So:
if (n == 0)
    return 1;

Example 3: Sum of numbers
Suppose:
sum(5) = 5 + 4 + 3 + 2 + 1
Eventually:
sum(0)
There is nothing left to add.
So:
if (n == 0)
    return 0;

Example 4: Delete middle of stack
You want to keep removing elements until you reach the middle.
So ask:
"When have I reached the element I want to delete?"
We used:
if (mid == 1) {
    s.pop();
    return;
}
That's the stopping point.

The mental formula
When you see a recursion problem, say this to yourself:

What am I repeating?
        ↓
When should I stop?
        ↓
What is the answer at that point?

For your palindrome:
Compare both ends
       ↓
When should I stop?
       ↓
Reached the middle
       ↓
left >= right
       ↓
return true

For the stack:
Remove top
    ↓
Move toward middle
    ↓
When should I stop?
    ↓
Reached middle
    ↓
Delete it + return

One sentence to remember
The base condition is the point where the problem becomes so simple that I already know the answer and don't need another recursive call.

TIME COMPLEXITY for linear recursion is O(n)
TIME COMPLEXITY for binary recursion is 2^n and for ternary recursion is 3^n

If the recursion branches into b calls at every level and has depth n, the recursion tree can have about bⁿ leaves.
*/


    public static void main(String[] args) {
        palindromeNumber palindrome = new palindromeNumber();
        int n = 1212121;
        System.out.println(palindrome.isPalindrome(n));
    }

    public boolean isPalindrome(int n) {
        int num = Math.abs(n);

        char[] ch = String.valueOf(num).toCharArray();

        int left = 0;
        int right = ch.length-1;

        return isPalindrome(ch, left, right);
    }

    public boolean isPalindrome(char[] ch, int left, int right){
        if(left>=right) return true;

        if(ch[left]!=ch[right]) return false;
        return isPalindrome(ch, left+1, right-1);
    }
}
