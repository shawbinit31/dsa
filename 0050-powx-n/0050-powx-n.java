class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0) return 0.0;
        
        // Handle values extremely close to 1.0 or -1.0 to avoid precision drift in massive loops
        if (Math.abs(Math.abs(x) - 1.0) < 1e-4) {
            return Math.pow(x, n);
        }
        
        long longN = n;
        if (longN < 0) {
            x = 1 / x;
            longN = -longN;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (longN > 0) {
            if ((longN & 1) == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            longN >>= 1;
        }
        
        return result;
    }
}