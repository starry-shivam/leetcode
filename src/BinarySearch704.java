import utils.ExecDuration;

public class BinarySearch704 {

    public static void main(String[] args) {
        BinarySearch704 obj = new BinarySearch704();
        int[] nums = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
        // Output: 4
        System.out.println(obj.search(nums, target));
        ExecDuration.measure(() -> obj.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else return mid;
        }
        return -1;
    }
}
