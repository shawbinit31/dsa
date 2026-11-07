import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, int pointCount, List<String> currentSegments, List<String> result) {
        if (pointCount == 4 && startIndex == s.length()) {
            result.add(String.join(".", currentSegments));
            return;
        }
        
        if (pointCount == 4 || startIndex == s.length()) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (startIndex + i > s.length()) {
                break;
            }

            String segment = s.substring(startIndex, startIndex + i);
            
            if ((segment.startsWith("0") && segment.length() > 1) || Integer.parseInt(segment) > 255) {
                continue;
            }

            currentSegments.add(segment);
            backtrack(s, startIndex + i, pointCount + 1, currentSegments, result);
            currentSegments.remove(currentSegments.size() - 1);
        }
    }
}