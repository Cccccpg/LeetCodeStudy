package LeetcodeHot100;

public class SearchMatrix_240 {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     *
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * 输出：true
     *
     * 这道题可以暴力双循环做
     * 也可以对双循环进行优化：从左下角开始向上遍历，因为左下角的元素一定是这一行最小的，但同时是这一列最大的
     *
     * 正确的解法：这个矩阵从右上角看，其实就是一棵搜索二叉树，从右上角开始搜索，按照搜索二叉树的方法来做即可
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(matrix[0][0] > target){
            return false;
        }
        int i = 0, j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
