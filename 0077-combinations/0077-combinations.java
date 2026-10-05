import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if current combination size equals k, add a copy to results
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning optimization: stop if there aren't enough remaining numbers to fill k elements
        // n - (k - current.size()) + 1 is the upper bound for the current choice
        for (int i = start; i <= n - (k - current.size()) + 1; i++) {
            current.add(i);                            // Make choice
            backtrack(i + 1, n, k, current, result);   // Recurse to next step
            current.remove(current.size() - 1);        // Backtrack (undo choice)
        }
    }
}