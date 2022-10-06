package Offer;

public class Interview13 {
    /**
     *
     * 机器人的运动范围
     * 不能简单的将每一位相加，因为可能有障碍
     * 比如 k = 8时，(0,9)格子过不去，所以虽然(0,10)符合条件，但是机器人还是走不到这个格子上
     * 题目问的是机器人能走多少个格子，只能上下左右，不能跳
     * 所以需要用DFS的方法
     *
     * @param m
     * @param n
     * @param k
     * @return
     */

    public int movingCount(int m, int n, int k) {
        boolean[][] isVisited = new boolean[m][n];
        return DFS(0, 0, m, n, k, isVisited);
    }

    private int DFS(int i, int j, int m, int n, int k, boolean[][] isVisited) {
        if (i < 0 || i >= m || j < 0 || j >= n
                || (i / 10 + i % 10 + j / 10 + j % 10 > k) || isVisited[i][j]){
            return 0;
        }
        isVisited[i][j] = true;
        return DFS(i + 1, j, m, n, k, isVisited) + DFS(i - 1, j, m, n, k, isVisited)
                +DFS(i, j - 1, m, n, k, isVisited) + DFS(i, j + 1, m, n, k, isVisited) + 1;
    }
}
