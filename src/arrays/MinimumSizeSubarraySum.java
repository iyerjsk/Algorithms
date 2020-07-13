package arrays;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            while(currentSum >= s) {
                minLength = Math.min(minLength, i + 1 - left);
                currentSum -= nums[left];
                ++left;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
