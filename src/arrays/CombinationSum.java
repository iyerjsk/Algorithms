package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void combinationSum ( List<List<Integer>> result, List<Integer> currentList, int[] candidates, int index, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if(target < 0) {
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            currentList.add(candidates[i]);
            combinationSum (result, currentList, candidates, i, target - candidates[i]);
            currentList.remove(currentList.size() - 1);
        }

    }
}
