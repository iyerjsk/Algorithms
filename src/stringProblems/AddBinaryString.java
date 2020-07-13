package stringProblems;

public class AddBinaryString {
	
	public static String addBinary(String a, String b) {
		char[] a1 = a.toCharArray();
        char[] a2 = b.toCharArray();

        int i = a1.length - 1;
        int j = a2.length - 1;

        int carry = 0;
        String sum ="";
        while (i >= 0 || j >= 0 ) {
            int x  = i >= 0 ? a1[i] - '0' : 0;
            int y = j >= 0 ? a2[j] - '0'  : 0;
		    int res = (x +y + carry) % 2;
            carry = (x+y+carry) / 2 ;  
            sum = res + sum;
            
            i--; j--;
	    }
        
        if(carry > 0) {
            sum =  carry + sum;
        }
        
        return sum;
    }

	public static void main(String[] args) {
		System.out.println(addBinary("100", "11"));
		System.out.println(addBinary("11", "10"));

	}

}
