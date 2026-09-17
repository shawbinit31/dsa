class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
