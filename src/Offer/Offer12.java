package Offer;

public class Offer12 {
    /**
     * 在矩阵中找是否能够成单词word
     * @param board
     * @param word
     * @return
     */

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length, wordLength = word.length();
        if (m * n < wordLength){
            return false;
        }
        int index = 0;
        char[] chars = word.toCharArray();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (DFS(board, chars, isVisited, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean DFS(char[][] board, char[] chars, boolean[][] isVisited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || chars[start] != board[i][j] || isVisited[i][j]){
            return false;
        }
        if (start == chars.length - 1){
            return true;
        }
        isVisited[i][j] = true;
        boolean ans = false;
        ans = DFS(board, chars, isVisited, i + 1, j, start + 1)
                || DFS(board, chars, isVisited, i - 1, j, start + 1)
                || DFS(board, chars, isVisited, i, j - 1 , start + 1)
                || DFS(board, chars, isVisited, i, j + 1, start + 1);
        isVisited[i][j] = false;
        return ans;
    }
}
