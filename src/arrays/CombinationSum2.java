package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(result, candidates, new ArrayList<>(), 0 , target);
        return result;
    }

    private void combinationSum2 (List<List<Integer>> result, int[] candidates, List<Integer> currentList, int index, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }


        for(int i=index; i < candidates.length; i++) {
            if(i == index || candidates[i] != candidates[i-1]) {
                if(target - candidates[i] < 0) {
                    break;
                }
                currentList.add(candidates[i]);
                combinationSum2 (result, candidates, currentList, i + 1, target - candidates[i] );
                currentList.remove(currentList.size() -1);
            }
        }
    }
}
