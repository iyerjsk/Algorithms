package arrays;

import java.util.*;
import java.util.stream.Collectors;

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
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        if(candidates == null) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        combinationSum(result, new ArrayList<>(), candidates, 0, target);
//        return result;
//    }
//
//    private void combinationSum ( List<List<Integer>> result, List<Integer> currentList, int[] candidates, int index, int target) {
//        if(target == 0) {
//            result.add(new ArrayList<>(currentList));
//            return;
//        }
//
//        if(target < 0) {
//            return;
//        }
//
//        for(int i = index; i < candidates.length; i++) {
//            currentList.add(candidates[i]);
//            combinationSum (result, currentList, candidates, i, target - candidates[i]);
//            currentList.remove(currentList.size() - 1);
//        }
//
//    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

    int[] numCoins = new int[target + 1];
    List<List<Integer>> indexes = new ArrayList<>();
    for(int i = 0; i < numCoins.length;  i++) {
        numCoins[i] = Integer.MAX_VALUE;
        indexes.add(new ArrayList<>());
    }
    numCoins[0] = 0;

    Set<List<Integer>> result = new HashSet<>();
    for(int i = 0; i < candidates.length; i++) {
        for(int j = candidates[i]; j < numCoins.length; j++) {
            if(numCoins[j - candidates[i]] !=  Integer.MAX_VALUE) {
                numCoins[j] = 1 + numCoins[j - candidates[i]];
                indexes.get(j).add(i);
            }
        }
    }
    addToResult(indexes, target, result, new ArrayList<>(), candidates);
    return result.stream().distinct().collect(Collectors.toList());
}

    private void addToResult(List<List<Integer>> list, int index, Set<List<Integer>> results, List<Integer> result, int[] candidates) {
        if(index <= 0) {
            if(index == 0) {
                ArrayList<Integer> l = new ArrayList<>(result);
                Collections.sort(l);
                results.add(l);
            }
            return;
        }
        List<Integer> tmp = list.get(index);
        for(Integer i: tmp) {
            result.add(candidates[i]);
            addToResult(list, index - candidates[i], results, result, candidates);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{1,2}, 4);
    }
}
