import utils.ExecDuration;

import java.util.Stack;

public class ReversePolishNotation150 {

    public static void main(String[] args) {
        ReversePolishNotation150 obj = new ReversePolishNotation150();
        String[] input1 = new String[]{"2", "1", "+", "3", "*"};
        String[] input2 = new String[]{"4", "13", "5", "/", "+"};
        String[] input3 = new String[]{"10", "6", "9", "3", "/", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(obj.evalRPN(input1)); // 9
        System.out.println(obj.evalRPN(input2)); // 6
        System.out.println(obj.evalRPN(input3)); // 22
        System.out.println("----------------------------------");
        System.out.println("Execution Duration:");
        ExecDuration.measure(() -> obj.evalRPN(input3));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> rpnStack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = rpnStack.pop();
                int num1 = rpnStack.pop();
                int res = switch (token) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> num1 / num2;
                    default -> 0;
                };
                rpnStack.push(res);
            } else {
                rpnStack.push(Integer.parseInt(token));
            }
        }
        return rpnStack.pop();
    }

    private boolean isOperator(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }
}
