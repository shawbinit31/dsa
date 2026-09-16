class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        int[] lastSeen = new int[128]; // ASCII size mapping
        
        // Initialize last seen indices to -1
        java.util.Arrays.fill(lastSeen, -1);
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen inside the current window, move the left pointer
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }
            
            // Update last seen index of current character
            lastSeen[currentChar] = right;
            
            // Calculate maximum length so far
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}