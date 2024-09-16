import utils.ExecDuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement496 {

    public static void main(String[] args) {
        NextGreaterElement496 obj = new NextGreaterElement496();
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(obj.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4})));
        ExecDuration.measure(() -> obj.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
