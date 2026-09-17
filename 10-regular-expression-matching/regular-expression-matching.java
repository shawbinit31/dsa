class Solution {
    private Boolean[][] memo;

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p);
    }

    private boolean dp(int i, int j, String s, String p) {
        // Base case: if pattern is fully processed
        if (j == p.length()) {
            return i == s.length();
        }

        if (memo[i][j] != null) {
            return memo[i][j];
        }

        // Check if current characters match
        boolean firstMatch = (i < s.length() && 
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

        boolean ans;
        // Check if next character in pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // '*' matches 0 times OR '*' matches 1+ times (if current character matched)
            ans = dp(i, j + 2, s, p) || (firstMatch && dp(i + 1, j, s, p));
        } else {
            // Normal character or '.' match
            ans = firstMatch && dp(i + 1, j + 1, s, p);
        }

        memo[i][j] = ans;
        return ans;
    }
}
