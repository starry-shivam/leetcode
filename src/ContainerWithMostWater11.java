import utils.ExecDuration;

public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int result = 0;
        while (start < end) {
            int currArea = Math.min(height[start], height[end]) * (end - start);
            result = Math.max(result, currArea);
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater11 obj = new ContainerWithMostWater11();
        int[] input1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(obj.maxArea(input1)); // 49
        int[] input2 = {1, 1};
        System.out.println(obj.maxArea(input2)); // 1
        int[] input3 = {4, 3, 2, 1, 4};
        System.out.println(obj.maxArea(input3)); // 16
        int[] input4 = {1, 2, 1};
        System.out.println(obj.maxArea(input4)); // 2
        System.out.println("---------------------------------- ");
        System.out.println("ExecDuration for maxArea: ");
        ExecDuration.measure(() -> obj.maxArea(input1));
        ExecDuration.measure(() -> obj.maxArea(input2));
        ExecDuration.measure(() -> obj.maxArea(input3));
        ExecDuration.measure(() -> obj.maxArea(input4));
    }
}
