package anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input:
s: "abab" p: "ab"

Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
 * @author iyerjsk
 *
 */
public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // if the String is null there is no anagram with pattern
        if(s == null || s.length() == 0) return result;
        
        HashMap<Character, Integer> patternMap = new HashMap<>();
        char[] patArray = p.toCharArray();
        
        // loop through the pattern and store the character and its count in the map
        for(Character c: patArray) {
            Integer x = patternMap.get(c);
            x = x== null ? 1: ++x;
            patternMap.put(c, x);
        }
        
        char[] strArray = s.toCharArray();
        int patternLength = patArray.length;
        int strLength = strArray.length;
        int left = 0, right = 0 ;
        
        //Traverse through string array and use sliding window algorithm
        while (right < strLength) {
            char rightChar = strArray[right];
            Integer x = patternMap.get(rightChar);
            if(x == null ){
                while(left <= right) {
                   Integer y = patternMap.get(strArray[left]);
                    if(y != null) {
                        patternMap.put(strArray[left], ++y);    
                    }
                   ++left;  
                }
                ++right;
            } else if( x != null && x > 0) {
                patternMap.put(rightChar, --x);
                ++right;
                if(right - left == patternLength) {
                    result.add(left);
                    
                    // resetting back and increment left for next window
                    int y = patternMap.get(strArray[left]);
                    patternMap.put(strArray[left], ++y);
                    ++left;
                }
            } else {
                 int y = patternMap.get(strArray[left]);
                 patternMap.put(strArray[left], ++y);
                 ++left;
            }
        }
        return result;
    }
}
