import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // Step 1: Sort the array
        Arrays.sort(nums);
        
        // Initialize closestSum with the sum of the first three numbers
        int closestSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;

        // Step 2: Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            // Step 3: Two-pointer technique
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // If exact target sum found, return immediately
                if (currentSum == target) {
                    return currentSum;
                }

                // Update closestSum if current sum is closer to target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on comparison with target
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}