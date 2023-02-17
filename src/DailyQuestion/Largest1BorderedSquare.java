package DailyQuestion;

public class Largest1BorderedSquare {

    /**
     * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，
     * 并返回该子网格中的元素数量。如果不存在，则返回 0。
     *
     * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：9
     *
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m + 1][n + 1][2];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0)
                    continue;
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }

        int maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //沿当前坐标向上、向左找出最短距离，暂时看做是正方形的边长
                int curLen = Math.min(dp[i][j][0], dp[i][j][1]);
                //如果当前边长curLen小于maxLen，那么即使找到了，也不可能大于maxLen，所以可以跳过
                if (curLen <= maxLen)
                    continue;
                //此时curLen可以认为是正方形向下、向右的边长
                for(; curLen > maxLen; curLen--){
                    //判断向上和向左的长度是否大于curLen，如果不大于，那么就缩小正方形边长
                    if (dp[i][j - curLen + 1][1] >= curLen && dp[i - curLen + 1][j][0] >= curLen){
                        maxLen = curLen;
                        break;
                    }
                }
            }
        }
        return maxLen * maxLen;
    }
}
