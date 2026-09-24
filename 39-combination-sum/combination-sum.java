import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort to enable early pruning
        Arrays.sort(candidates); 
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, 
                           int[] candidates, int remain, int start) {
        // Base case: exact sum reached
        if (remain == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Early pruning: if the candidate is greater than the remaining target,
            // no need to check further because the array is sorted.
            if (candidates[i] > remain) {
                break;
            }

            // Make a choice
            currentList.add(candidates[i]);
            
            // Recurse with the same index 'i' since we can reuse the same element
            backtrack(result, currentList, candidates, remain - candidates[i], i);
            
            // Undo choice (backtrack)
            currentList.remove(currentList.size() - 1);
        }
    }
}

