class Solution {
    public int divide(int dividend, int divisor) {
        // Handle 32-bit overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert numbers to negative to avoid overflow when abs(Integer.MIN_VALUE)
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int result = 0;

        // Perform bit-shift division using subtraction
        while (a <= b) {
            int tempDivisor = b;
            int count = 1;

            // Double the divisor using bit shifts until it exceeds 'a'
            // Check (tempDivisor >= Integer.MIN_VALUE >> 1) to prevent overflow
            while (tempDivisor >= Integer.MIN_VALUE >> 1 && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                count <<= 1;
            }

            a -= tempDivisor;
            result += count;
        }

        return negative ? -result : result;
    }
}