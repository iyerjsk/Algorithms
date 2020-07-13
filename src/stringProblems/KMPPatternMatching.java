package stringProblems;

public class KMPPatternMatching {

	public static boolean isPatternMatch (String input, String pattern) {

		char[] inputArray = input.toCharArray();
	    char[] patternArray = pattern.toCharArray();
	          
	   // first create an array from pattern finding a suffix that is prefix
	    int[] patternIndex = new int[patternArray.length];

		int j = 0;
	    patternIndex[0] = 0;
	    for (int i = 1; i < patternArray.length;) {
			if (patternArray[j] == patternArray[i]) {
				patternIndex[i] = j + 1;
				j++;
				i++;
			} else {
				if ( j != 0) {
					j = patternIndex[j - 1];
				} else {
					patternIndex[i] = 0;
					i++;
				}
			}
			
		}
	          
	    System.out.println (patternIndex);

	 	int m = 0;
        int n = 0;
        while (n < inputArray.length && m < patternArray.length) {
			
			if (inputArray[n] == patternArray[m]) {
				m++;
				n++;
			} else{
				
				if (m != 0) {
					m = patternIndex[m - 1];
				} else {
					n++;
				}
			}
		}
        
        if (m == patternArray.length) {
			return true;
  		}

	    return false;
	}

	
	
	public static void main (String[] args) {
		String pattern = "abc";
		String input = "xhuoiabiabc";
		System.out.println(KMPPatternMatching.isPatternMatch(input, pattern));
	}

}
