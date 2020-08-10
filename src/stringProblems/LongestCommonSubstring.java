package stringProblems;

public class LongestCommonSubstring {

    public int getLongestCommonSubstring(String st1, String st2) {
        char[] c1= st1.toCharArray();
        char[] c2 = st2.toCharArray();

        int[][] result = new int[c1.length + 1][c2.length + 1];

        int maxLength = 0;

        for(int i = 1; i < result.length; i++) {
            for(int j = 1; j < result[0].length; j++ ) {
                result[i][j] = c1[i-1] == c2[j-1] ? 1 + result[i-1][j-1] : 0;
                if(result[i][j] > maxLength) {
                    maxLength = result[i][j];
                }
            }
        }

        return maxLength;
    }


    public void printLongestCommonSubstring(String st1, String st2) {
        char[] c1= st1.toCharArray();
        char[] c2 = st2.toCharArray();

        int[][] result = new int[c1.length + 1][c2.length + 1];

        int maxLength = 0;
        int[] endIndex = new int[2];
        for(int i = 1; i < result.length; i++) {
            for(int j = 1; j < result[0].length; j++ ) {
                result[i][j] = c1[i-1] == c2[j-1] ? 1 + result[i-1][j-1] : 0;
                if(result[i][j] > maxLength) {
                    maxLength = result[i][j];
                    endIndex[0] = i;
                    endIndex[1] = j;
                }
            }
        }

        String s = "";
        if(maxLength > 0) {
            int length = maxLength;
            int i = endIndex[0];
            int j = endIndex[1];
            while(i > 0 && j > 0 && result[i][j] > 0){
                s = c1[i - 1] + s ;
                --i;
                --j;
            }
        }

        System.out.println("Length of longest substring is "  + s);
    }

    public static void main(String[ ] args) {
        System.out.println("Length of longest substring is " + new LongestCommonSubstring().getLongestCommonSubstring("abcdaf", "zbcdf"));
        new LongestCommonSubstring().printLongestCommonSubstring("abcdaf", "zbcdf");
        System.out.println("Length of longest substring is " + new LongestCommonSubstring().getLongestCommonSubstring("abcefghi", "abciefgh"));
        new LongestCommonSubstring().printLongestCommonSubstring("abcefghi", "abciefgh");
    }
}
