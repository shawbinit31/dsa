class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the current index is beyond our reach, we can't move forward
            if (i > maxReach) {
                return false;
            }

            // Update the furthest index we can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // Early exit if we can already reach or pass the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}