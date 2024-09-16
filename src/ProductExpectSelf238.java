import utils.ExecDuration;

import java.util.Arrays;

public class ProductExpectSelf238 {

    public static void main(String[] args) {
        ProductExpectSelf238 obj = new ProductExpectSelf238();
        int[] nums = {4, 3, 2, 1, 2};
        System.out.println(Arrays.toString(obj.productExceptSelf(nums)));
        ExecDuration.measure(() -> obj.productExceptSelf(nums));
    }

    // Time complexity: O(n), Space complexity: O(1)
    // Output array doesn't count as extra space.
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;
        int leftProduct = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct = nums[i - 1] * leftProduct;
            output[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct = nums[i + 1] * rightProduct;
            output[i] = output[i] * rightProduct;
        }

        return output;
    }
}
