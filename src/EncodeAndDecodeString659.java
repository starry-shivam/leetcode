import utils.ExecDuration;

import java.util.List;

public class EncodeAndDecodeString659 {

    public String encode(List<String> strs) {
        // write your code here
    }


    public List<String> decode(String str) {
        // write your code here
    }

    public static void main(String[] args) {
        EncodeAndDecodeString659 obj = new EncodeAndDecodeString659();
        List<String> strs = List.of("lint", "code", "love", "you");
        String encoded = obj.encode(strs);
        System.out.println(encoded);
        System.out.println(obj.decode(encoded));
        ExecDuration.measure(() -> obj.encode(strs));
        ExecDuration.measure(() -> obj.decode(encoded));
    }
}
