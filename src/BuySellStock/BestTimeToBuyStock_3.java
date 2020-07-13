package BuySellStock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */

/**
 *
 *                          T[i][j-1] -- Not Transacting the day at all
 *  Solution: T[i][j] =
*                          prices[j] + maxDiff, maxDiff = Math.max (maxDiff, (T[i-1][j] - price[j])
 */
public class BestTimeToBuyStock_3 {
    public int maxProfit(int k, int[] prices) {
        if(prices == null || prices.length < 1) return 0;

        int[][] T = new int[k +1][prices.length];
        for(int i = 1; i < T.length; i++) {
            int maxDiff = Integer.MIN_VALUE;
            for(int j = 1; j < T[0].length; j++) {
                maxDiff = Math.max(maxDiff, T[i-1][j-1] - prices[j - 1 ]);
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff );
            }
        }

        return T[k][prices.length  - 1];
    }

    public static void main(String[] args) {
        int[] prices =  new int[] {3,3,5,0,0,3,1,4};
        System.out.println(new BestTimeToBuyStock_3().maxProfit(2, prices));
        prices =  new int[] {1,2,3,4,5};
        System.out.println(new BestTimeToBuyStock_3().maxProfit(2, prices));
        prices =  new int[] {7,6,4,3,1};
        System.out.println(new BestTimeToBuyStock_3().maxProfit(2, prices));

    }
}
