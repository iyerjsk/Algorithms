package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsets(result, current, nums, 0);
        result.add(current);
        return result;
    }

    private void subsets(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            subsets(result, current, nums, i + 1);
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
        }
    }
}
