import utils.ExecDuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

    public static void main(String[] args) {
        ThreeSum15 obj = new ThreeSum15();
        int[] input1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(obj.threeSum(input1)); // [[-1,-1,2],[-1,0,1]]
        int[] input2 = {};
        System.out.println(obj.threeSum(input2)); // []
        int[] input3 = {0};
        System.out.println(obj.threeSum(input3)); // []
        int[] input4 = {0, 0, 0};
        System.out.println(obj.threeSum(input4)); // [[0,0,0]]
        int[] input5 = {1, 1, -2};
        System.out.println(obj.threeSum(input5)); // [[-2,1,1]]
        int[] input6 = {3, 0, -2, -1, 1, 2};
        System.out.println(obj.threeSum(input6)); // [[-2,-1,3],[-2,0,2],[-1,0,1]]
        int[] input7 = {0, 0, 0, 0};
        System.out.println(obj.threeSum(input7)); // [[0,0,0]]
        int[] input8 = {-2, 0, 1, 1, 2};
        System.out.println(obj.threeSum(input8)); // [[-2,0,2],[-2,1,1]]
        int[] input9 = {1, 2, -2, -1};
        System.out.println(obj.threeSum(input9)); // []
        int[] input10 = {1, 2, -2, -1, 0};
        System.out.println(obj.threeSum(input10)); // [[-2,-1,3],[-2,0,2],[-1,0,1]]
        System.out.println("---------------------------------- ");
        System.out.println("ExecDuration for threeSum: ");
        ExecDuration.measure(() -> obj.threeSum(input1));
        ExecDuration.measure(() -> obj.threeSum(input2));
        ExecDuration.measure(() -> obj.threeSum(input3));
        ExecDuration.measure(() -> obj.threeSum(input4));
        ExecDuration.measure(() -> obj.threeSum(input5));
        ExecDuration.measure(() -> obj.threeSum(input6));
        ExecDuration.measure(() -> obj.threeSum(input7));
        ExecDuration.measure(() -> obj.threeSum(input8));
        ExecDuration.measure(() -> obj.threeSum(input9));
        ExecDuration.measure(() -> obj.threeSum(input10));
    }

    // Time: O(n^2), Space: O(n)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // Sort in asc order.
        ArrayList<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicates of current (fixed) element.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int curr = nums[i];
            int start = i + 1;
            int end = nums.length - 1;

            while (start < end) {
                int numStart = nums[start];
                int numEnd = nums[end];
                int sum = curr + numStart + numEnd;

                if (sum < 0) {
                    start++;
                } else if (sum > 0) {
                    end--;
                } else {
                    output.add(List.of(curr, numStart, numEnd));
                    // Skip duplicates of start and end pointers.
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    // Move both pointers.
                    start++;
                    end--;
                }
            }
        }
        return output;
    }
}
