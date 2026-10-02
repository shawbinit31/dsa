class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carryover needed, return early
            }
            digits[i] = 0; // 9 becomes 0, continue carryover
        }

        // If all digits were 9 (e.g., [9, 9, 9] -> [1, 0, 0, 0])
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}
