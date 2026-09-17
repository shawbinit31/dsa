class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Calculate current width and height
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate current area and update maxWater
            int area = width * currentHeight;
            maxWater = Math.max(maxWater, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}