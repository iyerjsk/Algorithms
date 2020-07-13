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
		if(tmp != null) {
			int len = tmp.length;
			String val = "";
			for(int i = 0; i < len; i ++) {
				val += tmp[i];
				String label = c[len - i - 1];
				if(label.length() > 0)  {
					if(builder.length() > 0 ) {
						builder.append(" ");
					}
					builder.append(convertToWord (val, label));
					val = "";
				}
			}
			
			if(val.length() > 0) {
				if(builder.length() > 0 ) {
					builder.append(" ");
				}
				builder.append(convertToWord (val, ""));
			}
		}
		
 
		return builder.toString();
	}
	
	private static String convertToWord(String value, String label) {
		String result = "";
		int tmp = Integer.parseInt(value);
		if(tmp < 20) {
			result += a[tmp];
		}else {
			result += b[(tmp/10)] + " " + a[(tmp % 10)];
			
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
