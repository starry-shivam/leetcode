import utils.ExecDuration;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeString659 {

    public static void main(String[] args) {
        EncodeAndDecodeString659 obj = new EncodeAndDecodeString659();
        List<String> strs = List.of("lint", "code", "love", "you");
        String encoded = obj.encode(strs);
        System.out.println("Encoded: " + encoded);
        System.out.println("Decoded: " + obj.decode(encoded));
        ExecDuration.measure(() -> obj.encode(strs));
        ExecDuration.measure(() -> obj.decode(encoded));
    }

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length());
            stringBuilder.append("#");
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        ArrayList<String> output = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            String word = str.substring(i, i + length);
            output.add(word);
            i += length;
        }
        return output;
    }
}
