class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for characters in t
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int count = t.length(); // Number of characters still needed
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            
            // If the character is needed, decrement the count
            if (map[rightChar] > 0) {
                count--;
            }
            map[rightChar]--; // Decrement frequency in map
            right++;

            // When a valid window is found, try to shrink it from the left
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                map[leftChar]++; // Restore count in map
                
                // If character count becomes positive, we lack a character from t
                if (map[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    }
}