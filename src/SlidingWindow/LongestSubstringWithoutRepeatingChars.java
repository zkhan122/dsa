package SlidingWindow;

import java.util.ArrayList;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        /* my solution
        iterate over string, add each char to list
        if char in list continue else add
        len(list) = answer
        */
        ArrayList<Character> buffer = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (buffer.contains(c)) {
                continue;
            } else {
                buffer.add(c);
            }
        }
        return buffer.size();
    }

    public static void main(String[] args) {
        String s1 = "zxyzxyz";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "xxxx";
        System.out.println(lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3));
    }
}
