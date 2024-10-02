import java.util.ArrayList;
import java.util.HashSet;

public class LongestSubsString3 {

    public static void main(String[] args) {
        LongestSubsString3 obj = new LongestSubsString3();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(obj.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(obj.lengthOfLongestSubstring("pwwkew")); // 3
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        int res = 0;
        HashSet<Character> set = new HashSet<>();
    }
}
