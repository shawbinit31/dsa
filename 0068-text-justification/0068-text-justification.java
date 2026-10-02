import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        int n = words.length;

        while (index < n) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder sb = new StringBuilder();
            int count = last - 1 - index; // Number of gaps between words

            // Last line or line with only one word -> Left-justified
            if (last == n || count == 0) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                // Fully justified
                int spaces = maxWidth - totalChars + count; // Total space budget
                int evenSpaces = spaces / count;
                int remainder = spaces % count;

                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    // Append base spaces per gap
                    for (int j = 0; j < evenSpaces; j++) {
                        sb.append(" ");
                    }
                    // Distribute remainder spaces from left to right
                    if (remainder > 0) {
                        sb.append(" ");
                        remainder--;
                    }
                }
                sb.append(words[last - 1]);
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}