import utils.ExecDuration;

import java.util.HashMap;

public class TwoSum1 {

    public static void main(String[] args) {
        TwoSum1 obj = new TwoSum1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = obj.twoSum(nums, target);
        System.out.println(result[0] + "," + result[1]);
        ExecDuration.measure(() -> obj.twoSum(nums, target));
    }

    // Time: O(n), Space: O(n)
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIdx.containsKey(target - nums[i])) {
                return new int[]{numToIdx.get(target - nums[i]), i};
            }
            numToIdx.put(nums[i], i);
        }
        return null;
    }
}
