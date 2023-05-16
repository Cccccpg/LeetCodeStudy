package LeetcodeHot100;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     *
     * 模拟就行，只需要判断好临界条件
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ansList = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int iStart = 0, jStart = 0; iStart < m && jStart < n; iStart++, jStart++){
            int iEnd = m - 1 - iStart, jEnd = n - 1 - jStart;
            //走最外边
            if(iStart < iEnd && jStart < jEnd){
                //上边
                for(int j = jStart; j < jEnd; j++){
                    ansList.add(matrix[iStart][j]);
                }
                //右边
                for(int i = iStart; i < iEnd; i++){
                    ansList.add(matrix[i][jEnd]);
                }
                //下边
                for(int j = jEnd; j > jStart; j--){
                    ansList.add(matrix[iEnd][j]);
                }
                //左边
                for(int i = iEnd; i > iStart; i--){
                    ansList.add(matrix[i][jStart]);
                }
            }
            //判断特殊情况，当中间只剩一个数时
            if(iStart == iEnd && jStart == jEnd){
                ansList.add(matrix[iStart][jStart]);
            }else if(iStart == iEnd){   //当中间剩一行时
                for(int j = jStart; j <= jEnd; j++){
                    ansList.add(matrix[iStart][j]);
                }
            }else if(jStart == jEnd){   //当中间剩一列时
                for(int i = iStart; i <= iEnd; i++){
                    ansList.add(matrix[i][jStart]);
                }
            }
        }
        return ansList;
    }
}
