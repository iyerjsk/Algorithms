package stringProblems;

public class ConvertNumberToWords {
	static String[] a = {"", "one ", "two ", "three ", "four ", 
	        "five ", "six ", "seven ", "eight ", 
	        "nine ", "ten ", "eleven ", "twelve ", 
	        "thirteen ", "fourteen ", "fifteen ", 
	        "sixteen ", "seventeen ", "eighteen ", 
	        "nineteen "
	    }; 
	
	static String[] b = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	
	static String[] c = {"", "", "hundred", "thousand", "", "lakh", "", "crore"};
	
	public static  String convertNumberToWords (String input) {
		StringBuilder builder  = new StringBuilder();
		char[] tmp = input.toCharArray();
		int len = tmp.length;
		int digit = 0;
		for(int i = 0; i < len; i ++) {
			digit = (digit * 10) + (tmp[i] - '0');
			String label = c[len - i - 1];
			if(label.length() > 0)  {
				if(builder.length() > 0 ) {
					builder.append(" ");
				}
				builder.append(convertToWord (digit, label));
				digit = 0;
			}
		}

		if(digit > 0) {
			if(builder.length() > 0 ) {
				builder.append(" ");
			}
			builder.append(convertToWord (digit, ""));
		}


		return builder.toString();
	}
	
	private static String convertToWord(int value, String label) {
		String result = "";
		if(value < 20) {
			result += a[value];
		}else {
			result += b[(value/10)] + " " + a[(value % 10)];
			
		}
		
		if(label.length() > 0) {
			result += " " + label;
		}
		
		return result;
	}

	public static void main(String[] args) {
		String input = "123456";
		System.out.println(ConvertNumberToWords.convertNumberToWords(input));
		
		
		input = "3456";
		System.out.println(ConvertNumberToWords.convertNumberToWords(input));
		
		input = "456";
		System.out.println(ConvertNumberToWords.convertNumberToWords(input));
		
	    input = "56";
		System.out.println(ConvertNumberToWords.convertNumberToWords(input));
		
		input = "6";
		System.out.println(ConvertNumberToWords.convertNumberToWords(input));

	}

}
