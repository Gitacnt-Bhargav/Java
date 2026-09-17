package questions.Stack_StackSimulationOrUndoOperation;

public class removeAllAdjacentDuplicatesInString {

//    Leet code - 1047 - Easy

/*
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.
We repeatedly make duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation:
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"

Constraints:
1 <= s.length <= 10^5
s consists of lowercase English letters.
*/

    public static void main(String[] args) {
        removeAllAdjacentDuplicatesInString removeAllAdjacentDuplicates = new removeAllAdjacentDuplicatesInString();
        String s = "abbbc";
        System.out.println(removeAllAdjacentDuplicates.removeDuplicates(s));
        System.out.println(removeAllAdjacentDuplicates.removeDuplicatesForMoreThanTwoAdjacent(s));
    }

    public String removeDuplicates(String s) {
        StringBuilder str = new StringBuilder();

        for(Character c: s.toCharArray()){
            int len = str.length();
            if(len > 0 && str.charAt(len-1)==c){ //in problem statement, mentioned as 2 adjacent duplicate chars, and so this logic works, if there are 3 duplicate chars, only 2 would be removed.
                str.deleteCharAt(len-1);
            }else{
                str.append(c);
            }
        }

        return str.toString();
    }

    public String removeDuplicatesForMoreThanTwoAdjacent(String s) {
        StringBuilder str = new StringBuilder();
        char delCh = 0;
        for(Character c: s.toCharArray()){
            int len = str.length();
            if(len > 0 && str.charAt(len-1)==c){
                delCh = c;      //here we are remembering what was the one deleted, so every 2 pairs would be removed and the last one will not be appended as given below
                str.deleteCharAt(len-1);
            }else{
                if(delCh!=c) {
                    str.append(c);
                    delCh = 0;
                }
            }
        }

        return str.toString();
    }



}
