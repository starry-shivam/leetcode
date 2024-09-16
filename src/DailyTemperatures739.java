import utils.ExecDuration;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures739 {

    public static void main(String[] args) {
        DailyTemperatures739 obj = new DailyTemperatures739();
        int[] input = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        // Output: [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(obj.dailyTemperatures(input)));
        ExecDuration.measure(() -> obj.dailyTemperatures(input));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
