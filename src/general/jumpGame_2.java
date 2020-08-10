package general;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 *
 * You can assume that you can always reach the last index.
 */
public class jumpGame_2 {
    //     public int jump(int[] nums) {
//         if(nums== null || nums.length < 2) return 0;
//         int maxReachable = nums[0]; // either old maxReachable or new max Reachable (Max Reachable at any point is index + value of array at that index (max number of steps from that point))
//         int numJumps = 1; // Number of jumps to reach a particular index. After the entire iteration, that is answer to question.
//         int stepsRemaining = nums[0]; // This is the number of steps remaining. When it becomes 0 (decrement during each iteration), it is recalculated by subtracting index from maxReachable.

//         for(int i = 1; i < nums.length; i++) {
//             if(i == nums.length - 1) {
//                 break;
//             }

//             maxReachable = Math.max(maxReachable, i + nums[i]);
//             stepsRemaining--;
//             if(stepsRemaining == 0) {
//                 stepsRemaining = maxReachable - i;
//                 numJumps++;

//                 // There are no more steps and hence you cannot reach the last index
//                 // if(steps == 0){
//                 //     jumps = -1;
//                 //     break;
//                 // }
//             }
//         }

//         return numJumps;
//     }

    public int jump(int[] nums) {
        int max = 0;
        int numJumps = 0;
        for(int i = 0, newMax = 0; i < nums.length - 1; i++) {
            newMax = Math.max (newMax, i + nums[i]);
            if(i == max) {
                numJumps++;
                max = newMax ;
            }
        }

        return max >= nums.length - 1? numJumps : -1;
    }
}
