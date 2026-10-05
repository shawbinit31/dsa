class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int wordLen = word.length();

        // Pruning 1: Quick check if word length exceeds total board cells
        if (wordLen > m * n) {
            return false;
        }

        // Pruning 2: Frequency check - verify board has enough of each character
        int[] boardFreq = new int[128];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                boardFreq[board[r][c]]++;
            }
        }
        for (char ch : word.toCharArray()) {
            if (--boardFreq[ch] < 0) {
                return false;
            }
        }

        // Pruning 3: Reverse search if head char occurs more frequently than tail char
        if (boardFreq[word.charAt(0)] > boardFreq[word.charAt(wordLen - 1)]) {
            word = new StringBuilder(word).reverse().toString();
        }

        // Search starting positions
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);

        board[r][c] = temp;

        return found;
    }
}