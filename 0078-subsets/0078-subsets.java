import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // Add a copy of the current subset to the result
        result.add(new ArrayList<>(current));

        // Explore all possible choices starting from the current index
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);                  // Include nums[i]
            backtrack(i + 1, nums, current, result); // Recurse with next index
            current.remove(current.size() - 1);    // Backtrack (exclude nums[i])
        }
    }
}