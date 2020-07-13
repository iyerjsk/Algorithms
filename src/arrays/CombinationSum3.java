package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(result, new ArrayList<>(), k, 1, n);
        return result;
    }

    private void combinationSum3(List<List<Integer>> result, List<Integer> currentList, int k, int start, int target) {
        if(target == 0 && k == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if(k <= 0 || target < 0) {
            return;
        }


        for(int i = start; i < 10; i++) {
            if(currentList.contains(i)) {
                continue;
            }
            if(target - i < 0) {
                break;
            }
            currentList.add(i);
            combinationSum3(result, currentList, k - 1, i + 1, target - i);
            currentList.remove(currentList.size() - 1);

        }
    }
}
