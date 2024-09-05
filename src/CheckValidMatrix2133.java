import utils.ExecDuration;

import java.util.HashSet;

public class CheckValidMatrix2133 {

    public boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (!rowSet.add(matrix[i][j])) return false;
                if (!colSet.add(matrix[j][i])) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckValidMatrix2133 obj = new CheckValidMatrix2133();
        int[][] matrix = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 2}
        };
        System.out.println(obj.checkValid(matrix));
        System.out.println(obj.checkValid(matrix2));
        ExecDuration.measure(() -> obj.checkValid(matrix));
    }
}
