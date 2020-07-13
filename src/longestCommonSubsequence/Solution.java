package longestCommonSubsequence;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 * Constraints:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 *
 *
 *                  T[i-1][j-1] + 1 if(char[i] == char[j])
 * T[i][j]
 *                Math.max(T[i-1][j], T[i][j-1]) otherwise
 */

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return  0;
        char[] input1 = text1.toCharArray();
        char[] input2 = text2.toCharArray();

        int[][] result = new int[input1.length + 1][input2.length + 1];

        for(int i = 1; i< result.length ; i++) {
            for(int j = 1; j < result[0].length; j++) {
                if(input1[i-1] == input2[j-1]) {
                    result [i][j] = result[i-1][j-1] + 1;
                }else {
                    result [i][j] = Math.max(result[i-1][j], result[i][j-1]);
                }
            }
        }

        return result[input1.length][input2.length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonSubsequence("abcde", "ace"));
        System.out.println(new Solution().longestCommonSubsequence("abcdaf", "acbcf"));
        System.out.println(new Solution().longestCommonSubsequence("abc", "abc"));
        System.out.println(new Solution().longestCommonSubsequence("abc", "def"));
    }
}

