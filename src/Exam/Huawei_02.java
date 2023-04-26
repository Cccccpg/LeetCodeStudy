package Exam;

import java.util.*;

public class Huawei_02 {

    /**
     * 给定一棵树，这个树有n个节点，节点编号从0开始依次递增，0固定为根节点。
     * 在这棵树上有一个小猴子,初始时该猴子位于根节点(0号)上，小猴子次可以沿着树上的边从一个节点挪到另一个节点，
     * 但这棵树上有一些节点设置有障碍物，如果某个节点上设置了障碍物，小猴子就不能通过连接该节点的边挪动到该节点上。
     * 问小猴子是否能跑到树的叶子节点(叶子节点定义为只有一条边连接的节点)，
     * 如果可以，请输出小猴子跑到叶子节点的最短路径(通过的边最少)，否则输出字符串NULL。
     *
     * 第一行给出数字n,表示这个树有n个节点，节点编号从0开始依次递增，0固定为根节点，1<=n<10000
     * 第二行给出数字edge,表示接下来有edge行，每行是一边接下来的edge行是边: xy,表示x和y节点有一条边连接
     * 边信息结束后接下来的一行给出数字block,表示接下来有block行，每行是一个障碍物
     * 接下来的block行是障碍物: x,示节点x上存在障碍物
     *
     * 输入：
     * 4
     * 3
     * 0 1
     * 0 2
     * 0 3
     * 2
     * 2
     * 3
     * 输出：0->1
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int edge = sc.nextInt();
        int[][] graph = new int[n][n];
        for (int i = 0; i < edge; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = 1;
        }
        int blockNum = sc.nextInt();
        int[] block = new int[blockNum];
        for (int i = 0; i < blockNum; i++) {
            block[i] = sc.nextInt();
        }

        System.out.println(getPath(graph, block));
    }

    private static List<Integer> getPath(int[][] graph, int[] block) {
        ArrayList<Integer> path = new ArrayList<>();
        return null;
    }
}
