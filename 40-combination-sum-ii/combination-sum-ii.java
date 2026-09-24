import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to handle duplicates and allow pruning
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: target met
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: if candidate exceeds target, subsequent candidates will too
            if (candidates[i] > target) {
                break;
            }

            // Skip duplicate elements at the same tree depth
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose
            current.add(candidates[i]);
            
            // Explore (i + 1 ensures each element is used at most once)
            backtrack(candidates, target - candidates[i], i + 1, current, result);
            
            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}