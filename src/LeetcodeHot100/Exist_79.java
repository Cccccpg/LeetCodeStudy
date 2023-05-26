package LeetcodeHot100;

public class Exist_79 {
    private boolean find;

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
     * 如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     *
     * 经典的回溯题，按照回溯三部曲来做
     * 1.确定回溯所需参数值和返回值
     * 2.确定终止条件
     * 3.编写回溯遍历过程
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        find = false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                backTracking(board, word, 0, i, j, isVisited);
            }
        }
        return find;
    }

    public void backTracking(char[][] board, String word, int index, int i, int j, boolean[][] isVisited){
        // 不在边界内 || 已经找到匹配的字符串 || 字符不同 || 已经访问过该节点 确定回溯终止条件
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || find
                || board[i][j] != word.charAt(index) || isVisited[i][j]){
            return;
        }
        //确定回溯终止条件：上述条件都满足，且找到最后一个字符时，说明此时二维矩阵中存在字母word
        if(index == word.length() - 1){
            find = true;
            return;
        }
        //将此刻访问的坐标设为true，表示已经访问过这个坐标
        isVisited[i][j] = true;
        //开始向四个方向递归
        backTracking(board, word, index + 1, i - 1, j, isVisited);
        backTracking(board, word, index + 1, i + 1, j, isVisited);
        backTracking(board, word, index + 1, i, j - 1, isVisited);
        backTracking(board, word, index + 1, i, j + 1, isVisited);
        //回溯，撤销状态
        isVisited[i][j] = false;
    }
}
