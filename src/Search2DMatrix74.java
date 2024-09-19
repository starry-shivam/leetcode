import utils.ExecDuration;

public class Search2DMatrix74 {

    public static void main(String[] args) {
        Search2DMatrix74 obj = new Search2DMatrix74();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        // Output: true
        System.out.println(obj.searchMatrix(matrix, target));
        ExecDuration.measure(() -> obj.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int start = 0;
        int end = matrix.length * cols - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] < target) {
                start = mid + 1;
            } else if (matrix[mid / cols][mid % cols] > target) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}