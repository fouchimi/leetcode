import java.util.Stack;

public class Problem232 {

    private Stack<Integer> first, second;

    public Problem232() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        if(empty()) second.push(x);
        first.push(x);
    }

    public int pop() {
        int top = second.pop();
        while (first.size() > 1) second.push(first.pop());
        first.pop();
        if(!empty()) {
            int newTop = second.peek();
            while (!empty()) first.push(second.pop());
            second.push(newTop);
        }
        return top;
    }

    public int peek() {
        return second.peek();
    }

    public boolean empty() {
        return second.isEmpty();
    }

    public static void main(String[] args) {
        Problem232 problem232 = new Problem232();
        problem232.push(1);
        problem232.push(2);
        problem232.push(3);
        System.out.println(problem232.pop());
        System.out.println(problem232.pop());
        System.out.println(problem232.pop());
        System.out.println(problem232.empty());
    }
}
