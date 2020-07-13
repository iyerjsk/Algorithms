package stringProblems;

public class CompareVersion {
	public int compareVersion(String version1, String version2) {
        char[] version1Array = version1.toCharArray();
        char[] version2Array = version2.toCharArray();
        
        int i = 0, j = 0;
        while (i < version1Array.length || j < version2Array.length) {

            String firstStr = "" ;
            String secondStr ="" ;
            
            while (i < version1Array.length) {
                char ch = version1Array[i];
                i++;
                if(ch == '.') break;
                firstStr += ch;
            }
            
            while (j < version2Array.length) {
                char ch = version2Array[j];
                j++;
                if(ch == '.') break;
                secondStr += ch;
            }
            
            int first = convertString(firstStr);
            int second  = convertString(secondStr);
            if(first < second) return -1;
            
            if(first > second) return 1;
        }
        return 0;
    }
    
    private int convertString (String str) {       
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        int result = 0;
        while (i < length) {
            int digit = charArray[i] - '0';
            result += digit * Math.pow(10, (length - i - 1));
            i++;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	CompareVersion compare = new CompareVersion();
    	System.out.println(compare.compareVersion("1.0", "1"));
    }
}
