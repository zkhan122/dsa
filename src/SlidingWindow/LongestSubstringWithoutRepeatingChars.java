package SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int longest = 0;
        int N = s.length();
        HashSet<Character> set = new HashSet<Character>();

        for (int right = 0; right < N; right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left)); // cuz here s[r] == s[l] so remove s[l]
                left++;
            }
            int window_size = (right - left) + 1;
            longest = Math.max(longest, window_size);
            set.add(s.charAt(right));
        }
        return longest;
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
