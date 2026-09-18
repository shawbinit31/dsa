import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the array to use two-pointer technique and skip duplicates easily
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Pruning / Early Exit conditions to speed up execution
            long sumMin = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (sumMin > target) break; // Smallest possible sum exceeds target

            long sumMax = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (sumMax < target) continue; // Largest possible sum with current nums[i] is smaller than target

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Pruning / Early Exit conditions
                long sumMinJ = (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (sumMinJ > target) break;

                long sumMaxJ = (long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (sumMaxJ < target) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // Use long to prevent integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicates for the third and fourth elements
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}