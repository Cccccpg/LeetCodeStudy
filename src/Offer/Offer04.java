package Offer;

public class Offer04 {

    /**
     *
     * 在一个 n * m 的二维数组中，
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *
     * @param matrix
     * @param target
     * @return
     */

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0 || matrix == null)
            return false;
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] <= target){
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }
}
