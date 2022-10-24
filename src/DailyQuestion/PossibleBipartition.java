package DailyQuestion;

public class PossibleBipartition {

    /**
     *
     * 1.创建二维数组matrix记录n个数之间的互斥关系
     * 2.从第一行开始遍历，如果发现有互斥的，那么继续对这个数进行深度遍历，找是否有其他数与它互斥
     * 3.分为a、b两组，分别记录情况
     * 4.最终得出a、b两组分组情况
     *
     * group = 1,表示被分配到a组
     * group = -1,表示被分配到b组
     * group = 0,表示未被分组
     *
     * @param n
     * @param dislikes
     * @return
     */

    public boolean possibleBipartition(int n, int[][] dislikes){
        int[][] matrix = new int[n + 1][n + 1];

        //将互斥关系写入二维矩阵
        for (int[] dislike : dislikes) {
            matrix[dislike[0]][dislike[1]] = 1;
            matrix[dislike[1]][dislike[0]] = 1;
        }
        //记录分组情况
        int[] record = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            //只需要判断record == 0的位置就行，其他已经被分组的位置不用查看了
            if (record[i] == 0 && !DFS(matrix, record, i, 1, n)){
                return false;
            }
        }
        return true;
    }

    private boolean DFS(int[][] matrix, int[] record, int index, int group, int n) {
        record[index] = group;
        for (int i = 1; i <= n; i++) {
            if (i == index) {
                continue;
            }
            if (matrix[index][i] == 1 && record[i] == group){
                return false;
            }
            if (matrix[index][i] == 1 && record[i] == 0
                    && !DFS(matrix, record, i, group * -1, n)){
                return false;
            }
        }
        return true;
    }
}
