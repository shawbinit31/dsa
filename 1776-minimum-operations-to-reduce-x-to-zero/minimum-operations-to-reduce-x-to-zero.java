class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;
        
        // If the total sum is less than x, it's impossible to reach x
        if (target < 0) return -1;
        // If the total sum is exactly x, we must remove all elements
        if (target == 0) return nums.length;

        int maxLength = -1;
        int currentSum = 0;
        int left = 0;

        // Sliding window to find the longest subarray with sum == target
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        // Minimum operations is the total length minus the longest subarray length
        return maxLength != -1 ? nums.length - maxLength : -1;
    }
}