import utils.ExecDuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses22 {

    public static void main(String[] args) {
        GenerateParentheses22 obj = new GenerateParentheses22();
        System.out.println(Arrays.toString(obj.generateParenthesis(2).toArray()));
        ExecDuration.measure(() -> obj.generateParenthesis(3));
        ExecDuration.measureInMs(() -> obj.generateParenthesis(12));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        recurse(n, 0, 0, stack, result);
        return result;
    }

    public void recurse(int n, int openN, int closedN, Stack<String> s, List<String> res) {

        if (s.size() == n * 2) {
            StringBuilder sb = new StringBuilder();
            for (String str : s) {
                sb.append(str);
            }
            res.add(sb.toString());
            return;
        }

        if (openN < n) {
            s.push("(");
            recurse(n, openN + 1, closedN, s, res);
            s.pop();
        }

        if (closedN < openN) {
            s.push(")");
            recurse(n, openN, closedN + 1, s, res);
            s.pop();
        }
    }

}
