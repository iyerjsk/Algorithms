package general;

public class Prime {

    /**
     * This method returns if the  number is prime or not
     * @param number
     * @return true if prime else false
     *
     *
     * Complexity is O(Sqrt(n))
     */
    public boolean isPrime (double number) {
        if (number <= 1) return false;

        if(number  == 2 || number == 3) return true;

        if(number % 2 == 0 || number % 3 == 0)  return false;

        for (int i = 5 ; i <= Math.sqrt(number); i = i + 6) {
            if(number % i == 0 || number % (i + 2) == 0) return false; // Checking if number is divisible 6k + 1 and 6k - 1
        }

        return true;
    }

    /**
     *
     * Run time complexity is O(nlog(logn)))
     * Space complexity is O(n)
     *
     */
    public void printAllThePrimeNumbers(int n) {
        boolean[] primeNumbers = new boolean[n + 1];

        for(int i = 2; i <= n ; i++) {
            primeNumbers[i] = true;
        }


        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(primeNumbers[i]) {
                for(int j = i * i ; j <= n ; j += i) {
                    primeNumbers[j] = false;
                }
            }
        }


        for(int i = 0; i <= n ; i++) {
            if(primeNumbers[i]) {
                System.out.print(i + " ") ;
            }
        }


    }

    public static void main(String[] args) {
        Prime prime = new Prime();

        System.out.println(prime.isPrime(11) );
        System.out.println(prime.isPrime(121) );

        System.out.println("");

        prime.printAllThePrimeNumbers(100);
    }
}
