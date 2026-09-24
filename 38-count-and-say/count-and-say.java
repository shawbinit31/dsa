class Solution {
    public String countAndSay(int n) {
        // Base case
        String currentStr = "1";
        
        // Build the sequence iteratively up to n
        for (int i = 1; i < n; i++) {
            StringBuilder nextStr = new StringBuilder();
            int len = currentStr.length();
            int j = 0;
            
            while (j < len) {
                int count = 1;
                // Count consecutive identical characters
                while (j + 1 < len && currentStr.charAt(j) == currentStr.charAt(j + 1)) {
                    count++;
                    j++;
                }
                
                // Append the count followed by the digit character
                nextStr.append(count);
                nextStr.append(currentStr.charAt(j));
                j++;
            }
            
            currentStr = nextStr.toString();
        }
        
        return currentStr;
    }
}
