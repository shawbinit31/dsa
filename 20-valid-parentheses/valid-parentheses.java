import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        // Quick check: Odd length strings cannot be balanced
        if (s.length() % 2 != 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // Push expected matching closing bracket onto the stack
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } 
            // If stack is empty or doesn't match top character, it's invalid
            else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        // Valid if all open brackets have been properly closed
        return stack.isEmpty();
    }
}