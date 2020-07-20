package coin_changing;

/**
 *
 * number of ways that we can get the total with available coins
 *
 */
public class CoinChangingProblem_2 {

    public int numberOfWays(int[] coins, int sum) {

        int[][]  T = new int[coins.length + 1][sum + 1];
        for(int i = 0; i < T.length; i++) {
            T[i][0] = 1;
        }

        for(int i = 1; i < T.length; i++) {
            for(int j = 1; j < T[0].length; j++) {
                if(j >= coins[i-1]) {
                    T[i][j] = T[i-1][j] +  T[i][j - coins[i-1]];
                } else {
                    T[i][j] = T[i -1][j];
                }
                System.out.println("value at " + i + " and " + j + " is " + T[i][j]);
            }
        }

        return T[coins.length][sum];
    }



    public static void main(String[ ] args) {
        System.out.println(new CoinChangingProblem_2().numberOfWays(new int[]{7, 3, 6, 2} , 12));
    }
}