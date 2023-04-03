package BackTracking;

public class SolveSudoku_37 {
    /**
     * 编写一个程序，通过填充空格来解决数独问题。
     *
     * 数独的解法需 遵循如下规则：
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     *
     * @param board
     */
    public void solveSudoku(char[][] board){
        backTracking(board);
    }

    public boolean backTracking(char[][] board){
        //难点就是这里的二维递归
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.'){
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){
                    if (isValid(i, j, k, board)){
                        board[i][j] = k;
                        if (backTracking(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char k, char[][] board) {
        //检查同一行是否有重复的元素
        for (int i = 0; i < col; i++) {
            if (board[row][i] == k){
                return false;
            }
        }
        //检查同一列是否有重复的元素
        for (int i = 0; i < row; i++) {
            if (board[i][col] == k){
                return false;
            }
        }
        //检查一个九宫格内是否有重复的元素
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++){
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == k){
                    return false;
                }
            }
        }
        return true;
    }
}
