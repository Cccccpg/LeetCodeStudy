package LeetcodeHot100;

public class CanFinish_207 {

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     *
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     *
     * 方法：
     * 1.统计每个课被指向次数，初始被指向次数为0的肯定是安全的（不在环上）。
     * 2.每被安全课程指向一次，被指次数减一，
     * 3.如果被指次数减到0，说明该课程全部指向都来自安全课程，则它也是安全的。
     * 示例：n = 6，先决条件表：[[3, 0], [3, 1], [4, 1], [4, 2], [5, 3], [5, 4]]
     * 0 1 2 3 4 5
     * 1 2 1 1 1 0
     *
     *  0 1 2 3 4 5
     *  1 2 1 0 0 0
     *
     *  0 1 2 3 4 5
     *  0 1 1 0 0 0
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(len == 0){
            return true;
        }
        //每个课程被指向的次数
        int[] pointer = new int[numCourses];
        for(int[] p : prerequisites){
            pointer[p[1]]++;
        }
        //标记先修课程数组中的元素是否被移除
        boolean[] removed = new boolean[len];
        //移除元素的数量
        int remove = 0;
        while(remove < len){
            int curRemove = 0; //本轮移除的元素数量
            for(int i = 0; i < len; i++){
                if(removed[i]){ //被移除的元素跳过
                    continue;
                }
                int[] p = prerequisites[i];
                if(pointer[p[0]] == 0){ //被安全的课程指向
                    pointer[p[1]]--;
                    removed[i] = true;
                    curRemove++;
                }
            }
            //如果本轮一个元素都没删除，则没必要进行下一轮
            if(curRemove == 0){
                return false;
            }
            remove += curRemove;
        }
        return true;
    }
}
