package LeetcodeHot100;

import java.util.LinkedList;
import java.util.Queue;

public class OrangesRotting_994 {

    /**
     * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
     *
     * 值 0 代表空单元格；
     * 值 1 代表新鲜橘子；
     * 值 2 代表腐烂的橘子。
     * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
     *
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
     *
     * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid){
        int[] positionX = {-1, 1, 0, 0};
        int[] positionY = {0, 0, -1, 1};
        Queue<int []> queue = new LinkedList<>();
        //将烂橘子入队
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int ans = 0;
        //遍历队列中每个烂橘子
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] temp = queue.poll();
                //查看烂橘子上下左右四个方向是否有新鲜的橘子
                for (int j = 0; j < 4; j++) {
                    int x = temp[0] + positionX[j], y = temp[1] + positionY[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            //一次感染完毕，保证队列中不为空才能将ans++
            if (!queue.isEmpty()){
                ans++;
            }
        }

        //遍历矩阵，看是否还有新鲜橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
