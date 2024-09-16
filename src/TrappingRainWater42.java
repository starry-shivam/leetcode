import utils.ExecDuration;

public class TrappingRainWater42 {

    public static void main(String[] args) {
        TrappingRainWater42 obj = new TrappingRainWater42();
        int[] input1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(obj.trap(input1)); // 6
        int[] input2 = {4, 2, 0, 3, 2, 5};
        System.out.println(obj.trap(input2)); // 9
        int[] input3 = {1, 2, 3, 4, 5};
        System.out.println(obj.trap(input3)); // 0
        int[] input4 = {5, 4, 3, 2, 1};
        System.out.println(obj.trap(input4)); // 0
        int[] input5 = {5, 2, 1, 2, 1, 5};
        System.out.println(obj.trap(input5)); // 14
        int[] input6 = {5, 2, 1, 2, 1, 5, 2, 1, 2, 1, 5};
        System.out.println(obj.trap(input6)); // 20
        int[] input7 = {5, 2, 1, 2, 1, 5, 2, 1, 2, 1, 5, 2, 1, 2, 1, 5};
        System.out.println(obj.trap(input7)); // 26
        System.out.println("---------------------------------- ");
        System.out.println("ExecDuration for trap: ");
        ExecDuration.measure(() -> obj.trap(input1));
        ExecDuration.measure(() -> obj.trap(input2));
        ExecDuration.measure(() -> obj.trap(input3));
        ExecDuration.measure(() -> obj.trap(input4));
        ExecDuration.measure(() -> obj.trap(input5));
        ExecDuration.measure(() -> obj.trap(input6));
        ExecDuration.measure(() -> obj.trap(input7));
    }

    public int trap(int[] height) {
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;

        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            if (height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                int water = leftMax - height[l];
                sum += Math.max(water, 0);
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                int water = rightMax - height[r];
                sum += Math.max(water, 0);
                r--;
            }
        }
        return sum;
    }
}
