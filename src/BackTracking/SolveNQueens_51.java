package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolveNQueens_51 {

    /**
     * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
     *
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     *
     * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * @param n
     * @return
     */
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n){
        char[][] chessBoard = new char[n][n];
        for (char[] chars : chessBoard) {
            Arrays.fill(chars, '.');
        }
        backTracking(n, 0, chessBoard);
        return result;
    }

    public void backTracking(int n, int row, char[][] chessBoard){
        if (row == n){
            result.add(charArray2List(chessBoard));
            return;
        }
        for (int col = 0; col < n; col++){
            if (isValid(n, row, col, chessBoard)){
                chessBoard[row][col] = 'Q';
                backTracking(n, row + 1, chessBoard);
                chessBoard[row][col] = '.';
            }
        }
    }

    public List<String> charArray2List(char[][] chessBoard) {
        List<String> list = new ArrayList<>();
        for (char[] chars : chessBoard) {
            list.add(String.valueOf(chars));
        }
        return list;
    }

    public boolean isValid(int n, int row, int col, char[][] chessBoard){
        //检查该列是否符合要求
        for (int i = 0; i < row; i++){
            if (chessBoard[i][col] == 'Q'){
                return false;
            }
        }
        //不用检查行，因为在单层搜索的过程中，每一层递归只会选一行的一个元素，所以不用检查每行是否符合要求

        //检查对角线是否符合要求
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if (chessBoard[i][j] == 'Q'){
                return false;
            }
        }
        //检查反对角线是否符合要求
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if (chessBoard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
