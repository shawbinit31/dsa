class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // Pointer for the next valid position
        
        for (int i = 2; i < nums.length; i++) {
            // Compare current element with the element two positions back in the modified array
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}