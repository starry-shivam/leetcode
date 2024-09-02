import utils.ExecDuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {

    // Time: O(k * n * log(n)), Space: O(k * n)
    // k is the length of the longest string in strs.
    // n is the length of strs.
    public List<List<String>> groupAnagrams2(String[] strs) {
        var sortedToWordsMap = new HashMap<String, List<String>>();
        for (String str : strs) {
            var strToArr = str.toCharArray();
            Arrays.sort(strToArr);
            var sortedStr = Arrays.toString(strToArr);
            sortedToWordsMap.putIfAbsent(sortedStr, new ArrayList<>());
            sortedToWordsMap.get(sortedStr).add(str);
        }
        return new ArrayList<>(sortedToWordsMap.values());
    }

    // Time: O(k * n), Space: O(k * n)
    // k is the length of the longest string in strs.
    // n is the length of strs.
    public List<List<String>> groupAnagrams(String[] strs) {
        var sortedToWordsMap = new HashMap<String, List<String>>();
        for (String str : strs) {
            var charCount = new int[26];

            for (char c : str.toCharArray()) {
                charCount[c - 'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int count : charCount) {
                keyBuilder.append('#');
                keyBuilder.append(count);
            }
            String key = keyBuilder.toString();
            sortedToWordsMap.putIfAbsent(key, new ArrayList<>());
            sortedToWordsMap.get(key).add(str);
        }
        return new ArrayList<>(sortedToWordsMap.values());
    }


    public static void main(String[] args) {
        GroupAnagrams49 obj = new GroupAnagrams49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(obj.groupAnagrams(strs));
        ExecDuration.measure(() -> obj.groupAnagrams(strs));
    }
}
