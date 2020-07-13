package stringProblems;

public class ReverseToken {

	
	public static char[] reverseToken (char[] input) {
	      if (input == null || input.length == 0) return input;

	       reverse (input, 0 , input.length - 1);

	      int start= 0, i = 0;
	      while ( i < input. length) {
	             if (input[i] == ' ') {
	                  reverse (input, start, i - 1);
	                  start = i +1 ;
	             }
	             
	              i++;
	     }
	     reverse (input, start, i - 1); 
	     return input;

	}


	private static void reverse (char[] input, int start, int end) {
	      for (int i = start; i <= (end -  start) /2 + start; i++) {
	             char temp = input[i];
	             input[i] = input[end- i + start];
	             input[end - i + start]  = temp;
	     }	
	}
	
	
	public static void main(String[] args) {
		System.out.println (ReverseToken.reverseToken("THE CAT IS BLACK".toCharArray()));
		System.out.println (ReverseToken.reverseToken("THE  CAT   IS BLACK".toCharArray()));

	}

}
