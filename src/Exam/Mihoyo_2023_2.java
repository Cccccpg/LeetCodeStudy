package Exam;
import java.util.*;

public class Mihoyo_2023_2 {

    /**
     * 米小游拿到了一棵有根树，树上有 n个节点，根节点编号为1，所有边的长度均为1。
     * 米小游每一次操作可以将一个新叶子节点接在原来的一个叶子上，新加的边的边长度也是1。
     * 米小游可以进行任意次操作。
     * 她想知道，操作结束后，与根节点的距离不超过k 的节点个数的最大值是多少。
     *
     * 输入描述:
     * 第一行输入两个整数n(1<=n<=10^5),k(0<=k<=10^9)
     * 接下来n-1行，每行输入两个整数u,u(1<=u,v<=n)表示节点u和节点v之间有一条边。
     *
     * 输出描述:
     * 输出一个整数表示答案。
     *
     * 示例：
     * 4 2
     * 1 2
     * 1 3
     * 2 4
     *
     * 输出：5
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            edge.get(a).add(b);
            edge.get(b).add(a);
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        boolean[] leaf = new boolean[n + 1];
        Arrays.fill(leaf, true);
        dis[1] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            for (int y : edge.get(x)) {
                if (dis[y] == -1) {
                    leaf[x] = false;
                    dis[y] = dis[x] + 1;
                    que.offer(y);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] > k) {
                continue;
            }
            ans++;
            if (leaf[i]) {
                ans += k - dis[i];
            }
        }

        System.out.println(ans);
    }
}
