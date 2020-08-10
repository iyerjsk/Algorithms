package stringProblems;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || wordDict.size() == 0) {
            return false;
        }
        return wordBreakDp(s, wordDict);
    }

    private boolean wordBreakDp(String input, List<String> wordDict) {
        //create a two dimension boolean array
        boolean[][] T = new boolean[input.length()][input.length()];

        for(int l = 0; l < input.length(); l++) {
            for(int i = 0, j = i + l; j < T[0].length; i++, j++){
                String subString = input.substring(i, j+1);
                if(wordDict.contains(subString)){
                    T[i][j] = true ;
                } else {
                    for(int k =i; k < j; k++) {
                        if(T[i][k] && T[k+1][j]) {
                            T[i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return T[0][input.length() -1];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();

        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new WordBreak().wordBreak("leetcode", wordDict));

        wordDict.clear();
        wordDict.add("apple");
        wordDict.add("pen");
        System.out.println(new WordBreak().wordBreak("applepenapple", wordDict));
    }
}
