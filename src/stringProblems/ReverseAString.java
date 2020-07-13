package stringProblems;

public class ReverseAString {

	public static char[] reverseString (char[] input) {
		if (input == null || input.length == 0 ) return input;

	     for (int i = 0; i < input.length/2 ; i++) {
	              char temp = input[i];
	              input[i] = input[input.length -1 - i];
	              input[input.length - 1 - i] = temp;
		}

	      return input;
	}
	
	public static void main(String[] args) {
		System.out.println (ReverseAString.reverseString("BLACK".toCharArray()));
		System.out.println (ReverseAString.reverseString("BLACK1".toCharArray()));
		System.out.println (ReverseAString.reverseString("THE CAT IS BLACK".toCharArray()));
	}

}
