class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Boolean arrays to track numbers 1-9 (1-indexed mapping to index 0-8)
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1'; // Convert '1'-'9' to 0-8
                    int boxIndex = (i / 3) * 3 + (j / 3);

                    // If already seen in row, column, or 3x3 box, return false
                    if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                        return false;
                    }

                    // Mark as seen
                    rows[i][num] = true;
                    cols[j][num] = true;
                    boxes[boxIndex][num] = true;
                }
            }
        }

        return true;
    }
}