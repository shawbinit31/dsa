class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        // Traverse both strings from right to left until both are processed and carry is 0
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Append the binary digit (0 or 1)
            result.append(sum % 2);
            // Update the carry (1 if sum >= 2, else 0)
            carry = sum / 2;
        }

        // Reverse to get the correct order (MSB to LSB)
        return result.reverse().toString();
    }
}