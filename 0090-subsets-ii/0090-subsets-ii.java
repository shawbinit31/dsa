import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Sort the array to handle duplicates easily
        Arrays.sort(nums);
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int[] nums, List<Integer> currentSubset, List<List<Integer>> result) {
        // Add the current subset to the result list
        result.add(new ArrayList<>(currentSubset));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates at the same tree level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Include the element and recurse
            currentSubset.add(nums[i]);
            backtrack(i + 1, nums, currentSubset, result);
            // Backtrack by removing the last element
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}