import utils.ExecDuration;

import java.util.Stack;

public class ValidParentheses20 {

    public static void main(String[] args) {
        ValidParentheses20 obj = new ValidParentheses20();
        System.out.println(obj.isValid("()")); // true
        System.out.println(obj.isValid("()[]{}")); // true
        System.out.println(obj.isValid("(]")); // false
        System.out.println(obj.isValid("([)](")); // false
        System.out.println(obj.isValid("{[]}")); // true
        System.out.println("----------------------------");
        System.out.println("Executions time:");
        ExecDuration.measure(() -> obj.isValid("()"));
        ExecDuration.measure(() -> obj.isValid("()[]{}"));
        ExecDuration.measure(() -> obj.isValid("(]"));
        ExecDuration.measure(() -> obj.isValid("([)]"));
        ExecDuration.measure(() -> obj.isValid("{[]}"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (c == ')' && stack.pop() != '(') {
                    return false;
                } else if (c == ']' && stack.pop() != '[') {
                    return false;
                } else if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
