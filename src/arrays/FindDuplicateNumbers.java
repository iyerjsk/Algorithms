package arrays;

import java.util.Arrays;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicateNumbers {

    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int slow_pointer = nums[0];
        int fast_pointer = nums[0];

        slow_pointer = nums[slow_pointer];
        fast_pointer = nums[nums[fast_pointer]];

        while(slow_pointer != fast_pointer) {
            slow_pointer = nums[slow_pointer];
            fast_pointer = nums[nums[fast_pointer]];
        }

        slow_pointer  = nums[0];

        while(fast_pointer != slow_pointer) {
            slow_pointer = nums[slow_pointer];
            fast_pointer =  nums[fast_pointer];
        }

        return slow_pointer;
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateNumbers().findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(new FindDuplicateNumbers().findDuplicate(new int[]{3,1,3,4,2}));
    }
}
