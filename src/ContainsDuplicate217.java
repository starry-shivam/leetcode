import utils.ExecDuration;

import java.util.HashSet;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        ContainsDuplicate217 solution = new ContainsDuplicate217();
        int[] nums = {1, 2, 3, 1}; // true
        int[] nums2 = {1, 2, 3, 4}; // false
        System.out.println(solution.containsDuplicate(nums));
        System.out.println(solution.containsDuplicate(nums2));
        ExecDuration.measure(() -> solution.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
