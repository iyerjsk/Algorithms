package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void generateSubsets(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++) {
            if(i == index || nums[i] != nums[i -1] ) {
                current.add(nums[i]);
                generateSubsets(result, current, nums, i+1);
                current.remove(current.size() - 1);
            }
        }
    }
}

