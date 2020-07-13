package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Can be used as solution for CombinationSum Problem
 *
 */
public class SubsetSumProblem {

    public List<List<Integer>>  findSubsets(int[] nums, int sum) {
        if(nums == null || nums.length == 0) return new ArrayList<>();

        boolean[][] T = new boolean [nums.length + 1][sum +1];
        for(int i = 0; i < T.length; i++) {
            T[i][0] = true;
        }

        // populate the two dimension array with given elements vs sum
        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if(j < nums[i -1])
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = T[i-1][j] || (nums[i-1] <= j && T[i-1][j - nums[i-1]]);
            }
        }

        // we return the value of T[nums.length][sum] if we need to find whether there is a subset or not
        List<List<Integer>> result  = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        addElementsToResult (nums, T, nums.length, sum, result, list);
        return result;
    }


    private void addElementsToResult (int[] nums, boolean[][] T, int i, int j , List<List<Integer>> lists, List<Integer> list) {
        if(j == 0) {
            lists.add(list);
            return;
        }

        // considering the current element not part of the sub array
        if(T[i -1][j]) {
            ArrayList<Integer> tmp = new ArrayList<>(list);
            addElementsToResult (nums, T, i -1, j , lists, tmp);
        }

        // considering the current element as part of the sub array
        if (nums[i - 1] <= j && T[i - 1][j - nums[i -1]]) {
            list.add(nums[i - 1 ]);
            addElementsToResult (nums, T, i -1, j - nums[i-1], lists, list);
        }

    }

    public void printArray(List<List<Integer>> list) {
        for(List<Integer> l : list) {
            System.out.println(Arrays.toString(l.toArray()));
        }
    }
    public static void main (String[] args) {
        SubsetSumProblem subsetProblem = new SubsetSumProblem();
        subsetProblem.printArray(subsetProblem.findSubsets(new int[]{10,1,2,7,6,1,5}, 8 ));
        subsetProblem.printArray(subsetProblem.findSubsets(new int[]{1,2,3,5,7}, 10 ));
        subsetProblem.printArray(subsetProblem.findSubsets(new int[]{1,1,1,2}, 3 ));
    }
}
