import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        boolean[] cols = new boolean[n];
        boolean[] mainDiag = new boolean[2 * n];
        boolean[] antiDiag = new boolean[2 * n];
        
        backtrack(0, n, board, cols, mainDiag, antiDiag, result);
        return result;
    }
    
    private void backtrack(int row, int n, char[][] board, boolean[] cols, boolean[] mainDiag, boolean[] antiDiag, List<List<String>> result) {
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int md = row - col + n;
            int ad = row + col;
            
            if (cols[col] || mainDiag[md] || antiDiag[ad]) {
                continue;
            }
            
            // Place queen
            board[row][col] = 'Q';
            cols[col] = true;
            mainDiag[md] = true;
            antiDiag[ad] = true;
            
            // Move to next row
            backtrack(row + 1, n, board, cols, mainDiag, antiDiag, result);
            
            // Remove queen (backtrack)
            board[row][col] = '.';
            cols[col] = false;
            mainDiag[md] = false;
            antiDiag[ad] = false;
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}