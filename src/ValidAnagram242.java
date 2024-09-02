import utils.ExecDuration;

import java.util.HashMap;

public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        // Best case scenario: O(1)
        if (s.length() != t.length()) {
            return false;
        }

        var sCharMap = new HashMap<Character, Integer>();
        var tCharMap = new HashMap<Character, Integer>();

        // Worst case scenario: O(n)
        for (int i = 0; i < s.length(); i++) {
            sCharMap.put(s.charAt(i), sCharMap.getOrDefault(s.charAt(i), 0) + 1);
            tCharMap.put(t.charAt(i), tCharMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sCharMap.equals(tCharMap);
    }

    public static void main(String[] args) {
        ValidAnagram242 obj = new ValidAnagram242();
        System.out.println(obj.isAnagram("anagram", "nagaram")); // true
        System.out.println(obj.isAnagram("rat", "car")); // false
        ExecDuration.measure(() -> obj.isAnagram("anagram", "nagaram"));
    }
}
