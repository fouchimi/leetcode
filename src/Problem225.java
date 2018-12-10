import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;


public class Problem225 {

    Deque<Integer> queue;

    Problem225() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()) throw new IndexOutOfBoundsException("Empty stack");
        return queue.removeLast();
    }

    /** Get the top element. */
    public int top() {
        if(empty()) throw new IndexOutOfBoundsException("Empty stack");
        return queue.getLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Problem225 problem225 = new Problem225();

        problem225.push(1);
        problem225.push(2);
        System.out.println(problem225.top());
        System.out.println(problem225.pop());
        System.out.println(problem225.empty());
    }
}
