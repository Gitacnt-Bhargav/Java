package questions.Stack_StackAndGreedy;

public class removeDuplicateLettersLexicoGraphical {

//    Leet code - 316 - Medium

/*
Given a string s, remove duplicate letters so that every letter appears once and only once.
You must make sure your result is the smallest in lexicographical order among all possible results.

Example 1:
Input: s = "bcabc"
Output: "abc"

Example 2:
Input: s = "cbacdcbc"
Output: "acdb"

Constraints:
1 <= s.length <= 10^4
s consists of lowercase English letters.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
*/
    public static void main(String[] args) {
        removeDuplicateLettersLexicoGraphical removeDuplicateLettersLexicoGraphical = new removeDuplicateLettersLexicoGraphical();
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLettersLexicoGraphical.removeDuplicateLetters(s));
    }

    public String removeDuplicateLetters(String s) {
        int[] lastIndexOfChar = new int[26]; //using this instead of hashmap, since the storage content is fixed
        boolean[] visited = new boolean[26]; //using this to store if the char was already considered or not

        StringBuilder stack = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            lastIndexOfChar[s.charAt(i) - 'a'] = i;
        }

        for(int i=0; i<s.length();i++){
            char ch = s.charAt(i);
            if(visited[ch - 'a']){ //if its already visited, do not do anyhthing, or do not consider into our stack since we should remove duplicates
                continue;
            }

            //here if stack is not empty, the prev char is greater than the current char, provided the prev char is repeating - which means the last index is not the same, but is of some future one
            while(!stack.isEmpty() && stack.charAt(stack.length()-1) > ch && lastIndexOfChar[stack.charAt(stack.length()-1) -'a']>i ){
                visited[stack.charAt(stack.length()-1)-'a'] = false; //we are making it false for the deleted char because, since we are deleting, the char could be present anywhere in the future also, and if its not false, it would be skipped without checking
                stack.deleteCharAt(stack.length()-1); //remove the last char
            }
            stack.append(ch);
            visited[ch-'a'] = true;
        }

        return stack.toString();
    }
}
