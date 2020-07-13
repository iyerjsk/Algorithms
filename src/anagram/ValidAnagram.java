package anagram;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	
	public boolean isAnagram(String s, String t) {
        Map<Character, Integer> words = new HashMap();
        char[] chars  =  s.toCharArray();
        for(char c: chars) {
            Integer existingCount = words.get(c);
            if(existingCount == null) {
                existingCount = 0;
            }
            ++existingCount;
            words.put(c, existingCount);
        }
        chars = t.toCharArray();
        for(char c: chars) {
            Integer existingCount = words.get(c);
            if(existingCount == null || existingCount == 0) {
                return false;
            }else {
                --existingCount;
            }
            if(existingCount == 0) {
                words.remove(c);
            }else {
                words.put(c, existingCount);
            }
            
        }
        
        return words.size() == 0;
    }

}
