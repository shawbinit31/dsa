class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;     // Pointer for the end of valid elements in nums1
        int j = n - 1;     // Pointer for the end of nums2
        int k = m + n - 1; // Pointer for the end of the merged array in nums1
        
        // While there are elements to merge in nums2
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}