import utils.ExecDuration;

import java.util.Arrays;

public class TwoSum167 {

    // Two pointers approach, uses constant space complexity
    // Time: O(n), Space: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] > target) {
                end--; // Decrease the number
            } else if (numbers[start] + numbers[end] < target) {
                start++; // Increase the number
            } else {
                return new int[]{start + 1, end + 1};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum167 obj = new TwoSum167();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(obj.twoSum(numbers, target))); // [1, 2]
        ExecDuration.measure(() -> obj.twoSum(numbers, target));
    }
}
