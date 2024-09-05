import utils.ExecDuration;

import java.util.HashSet;

public class LongestConsecutive128 {

    // Time: O(n), Space: O(n)
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;
        for (int num : numSet) {
            // Check if num is beginning of a sequence.
            if (!numSet.contains(num - 1)) {
                int curr = 1;
                int nextNum = num + 1;
                while (numSet.contains(nextNum)) {
                    curr++;
                    nextNum++;
                }
                if (curr > longest) longest = curr;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestConsecutive128 obj = new LongestConsecutive128();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(obj.longestConsecutive(nums));
        ExecDuration.measure(() -> obj.longestConsecutive(nums));
    }
}
