class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Sign is only allowed at index 0 or immediately after 'e' / 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // Dot is not allowed if another dot or an exponent was already seen
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // Exponent is not allowed if already seen or if no digits preceded it
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                seenDigit = false; // Reset seenDigit because exponent must be followed by integers
            } else {
                // Any invalid character
                return false;
            }
        }

        // Must end with at least one digit seen (especially after 'e'/'E')
        return seenDigit;
    }
}