import java.util.Stack;

public class MinStack155 {

    private final Stack<Integer> mainStack;
    private final Stack<Integer> minStack;

    public MinStack155() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack155 obj = new MinStack155();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin()); // -3
        obj.pop();
        System.out.println(obj.top()); // 0
        System.out.println(obj.getMin()); // -2
    }
}
