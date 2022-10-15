package DailyQuestion;

public class MaxChunksToSorted {

    /**
     * 当遍历到第i个位置时，如果可以切分为块，那么前i个位置的最大值一定等于i
     * 否则，一定有比i小的数划分到后面的块中，那块排序后，一定不满足升序
     * @param arr
     * @return
     */

    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            if (max == i){
                ans++;
            }
        }
        return ans;
    }
}
