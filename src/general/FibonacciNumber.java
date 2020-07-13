package general;

public class FibonacciNumber {
	public int fibonacciNumber(int n) {	
		//f(0) = 0
		if(n == 0) {
			return 0;
		}
		
		
		// f(1) = 1
		if(n == 1) {
			return 1;
		}
		
		// f(2) = f(1) + f (0)
		// f(n) = f(n-1) + f(n-2)
		
		return fibonacciNumber(n-1) + fibonacciNumber( n-2);
	}
	
	
	public static void main (String[] args) {
		System.out.println (new FibonacciNumber().fibonacciNumber(0));
		System.out.println (new FibonacciNumber().fibonacciNumber(10));
		System.out.println (new FibonacciNumber().fibonacciNumber(1));
	}

}
