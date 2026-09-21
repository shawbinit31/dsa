class Solution {
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Push -1 as the initial boundary index
        stack.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // New boundary index for invalid ')'
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        
        return maxLen;
    }
}