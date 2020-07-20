/**
 *  This method will help to find minimum number of coins needed to get the target sum
 * */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CoinChangingProblem {

    public List<Integer> minimumCoins(int[] coins, int target) {
        int[] numCoins = new int[target + 1];
        int[] coinIndexes = new int[target + 1];
        numCoins[0] = 0;
        coinIndexes[0] = -1;
        for(int i = 1; i < numCoins.length; i++) {
            numCoins[i] = Integer.MAX_VALUE;
            coinIndexes[i] = -1;
        }

        IntStream.range(0, coins.length).forEachOrdered(i -> {
            IntStream.range(1, numCoins.length).forEachOrdered(j ->{
                if(j >= coins[i] && numCoins[j - coins[i]] != Integer.MAX_VALUE) {
                    if(numCoins[j] > (1 + numCoins[j - coins[i]]) ) {
                        numCoins[j] = 1 + numCoins[j - coins[i]];
                        coinIndexes[j] = i;
                    }
                }
            });
        });

        System.out.println(Arrays.toString(numCoins));
        System.out.println(Arrays.toString(coinIndexes));
        List<Integer> list = new ArrayList<>();
        int currentIndex = coinIndexes.length - 1;
        while(currentIndex > 0) {
            int idx = coinIndexes[currentIndex];
            list.add(coins[idx]);
            currentIndex = currentIndex - coins[idx];
        }
        return list;
    }


    public static void main(String[ ] args) {
        System.out.println(new CoinChangingProblem().minimumCoins(new int[]{2,3,6,7}, 7));
    }
}