import java.util.HashMap;
import java.util.Map;

class Solution {
    // Memoization table to store results of previously checked subproblems
    private Map<String, Boolean> memo = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        // Base case: strings are identical
        if (s1.equals(s2)) {
            return true;
        }

        // Base case: length mismatch or base character set mismatch
        if (s1.length() != s2.length() || !hasSameCharacterCounts(s1, s2)) {
            return false;
        }

        // Create a unique key for the current pair of strings
        String key = s1 + "_" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int n = s1.length();

        // Try every possible split point i
        for (int i = 1; i < n; i++) {
            // Case 1: Substrings are NOT swapped
            boolean noSwap = isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                             isScramble(s1.substring(i), s2.substring(i));

            if (noSwap) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Substrings ARE swapped
            boolean swap = isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                           isScramble(s1.substring(i), s2.substring(0, n - i));

            if (swap) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    // Helper method: check if s1 and s2 contain the same frequency of characters
    private boolean hasSameCharacterCounts(String s1, String s2) {
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        for (int count : counts) {
    if (count != 0) {
        return false;
    }
}
return true;
    }}