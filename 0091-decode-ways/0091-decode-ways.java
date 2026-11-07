class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        // ways to decode string of length i-1 and i-2 respectively
        int prev2 = 1; // corresponds to dp[i-2]
        int prev1 = 1; // corresponds to dp[i-1]

        for (int i = 1; i < n; i++) {
            int current = 0;
            
            // Check single digit decode (s[i])
            int oneDigit = s.charAt(i) - '0';
            if (oneDigit >= 1 && oneDigit <= 9) {
                current += prev1;
            }
            
            // Check double digit decode (s[i-1] and s[i])
            int twoDigits = Integer.parseInt(s.substring(i - 1, i + 1));
            if (twoDigits >= 10 && twoDigits <= 26) {
                current += prev2;
            }
            
            // Shift pointers forward
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}