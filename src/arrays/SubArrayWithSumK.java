package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubArrayWithSumK {
    public int subarraySum(int[] nums, int k) {

        int sum = 0; // This is the variable that is going to calculate cummulative sum
        int result = 0; // number of count

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put (0, 1);
        for (int num : nums) {
            sum += num;

            // checking whether we have seen a sum such that we get K by adding the present value
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

    public List<int[]> printSubArrayWithSum (int[]  nums, int k) {
        int sum = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        map.computeIfAbsent(0, k1 -> new ArrayList<>()).add(-1);
        for(int i = 0; i < nums.length ; i ++) {
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                List<Integer> list = map.get(sum - k);
                for(Integer value: list) {
                    result.add(Arrays.copyOfRange(nums, value + 1, i + 1));
                }
            }
            map.computeIfAbsent(sum , C -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main (String[] args) {
        int[] nums = {3,4,-7,1,3,3,-7, 1,3,3};

        SubArrayWithSumK subArrayWithSumK = new SubArrayWithSumK();

        System.out.println(subArrayWithSumK.subarraySum(nums, 7));
        System.out.println(subArrayWithSumK.printSubArrayWithSum(nums, 7).size());
    }
}
