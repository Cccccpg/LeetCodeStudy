package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalNQueens_52 {
    private List<List<String>> result = new ArrayList<>();

    public int totalNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for(char[] c : chessboard){
            Arrays.fill(c, '.');
        }
        backTracking(n, 0, chessboard);
        return result.size();
    }

    public void backTracking(int n, int row, char[][] chessboard){
        if(row == n){
            result.add(charArray2List(chessboard));
            return;
        }
        for(int col = 0; col < n; col++){
            if(isValid(n, row, col, chessboard)){
                chessboard[row][col] = 'Q';
                backTracking(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public List<String> charArray2List(char[][] chessboard){
        List<String> list = new ArrayList<>();
        for(char[] c : chessboard){
            list.add(String.copyValueOf(c));
        }
        return list;
    }

    public boolean isValid(int n, int row, int col, char[][] chessboard){
        for(int i = 0; i < row; i++){
            if(chessboard[i][col] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(chessboard[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
