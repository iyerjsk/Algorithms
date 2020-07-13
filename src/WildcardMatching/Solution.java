package WildcardMatching;

/**
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 *
 *              T[i-1][j-1] if ith character and jth character are same or jth character is *
 * T[i][j] =
 *              T[i][j-1] || T[i-1][j] if jth character is ?
 *
 *
 *
 */

class Solution {
    public boolean isMatch(String s, String p) {
        int patLength = p.length();
        char[] patCharArray = p.toCharArray();
        char[] strCharArray = s.toCharArray();
        int writeIndex = 0;
        boolean isFirst = false;
        for (int i = 0; i < patLength; i ++){
            if(patCharArray[i] == '*') {
                if(isFirst) {
                    patCharArray[writeIndex++] = patCharArray[i];
                    isFirst = false;
                }
            } else {
                patCharArray[writeIndex++] = patCharArray[i];
                isFirst  = true;
            }
        }


        boolean[][] result = new boolean[strCharArray.length + 1][writeIndex + 1];
        if(writeIndex > 0 &&  patCharArray[0] ==  '*') {
            result[0][1] = true;
        }

        result[0][0] = true;
        for(int i = 1; i < result.length; i++) {
            for(int j = 1; j < result[0].length; j++) {
                if(strCharArray[i-1] == patCharArray[j-1] || patCharArray[j] == '?') {
                    result[i][j] = result[i-1][j-1];
                } else if(patCharArray[j] == '*') {
                    result[i][j] = result[i-1][j] || result[j-1][i];
                }
            }
        }

        return result[strCharArray.length][writeIndex];

    }

    public static void main(String[] args) {
        boolean result =  new Solution().isMatch("a", "a");
        System.out.println(result);
    }
}