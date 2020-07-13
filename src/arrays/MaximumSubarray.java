package arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {

    public int maxSubArray (int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int num: nums) {
            sum += num;
            sum = Math.max(sum , num);
            result = Math.max(sum, result);
        }
        return sum;
    }



    public static void main (String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        maximumSubarray.maxSubArray(nums);
    }
}
