import java.util.Stack;

public class Problem844 {

    public boolean backspaceCompare(String S, String T) {

        Stack<Character> stackOne = getNewStack(S);
        Stack<Character> stackTwo = getNewStack(T);

        while ((!stackOne.isEmpty() && !stackTwo.isEmpty()) && (stackOne.peek() == stackTwo.peek())) {
            stackOne.pop();
            stackTwo.pop();
        }
        return stackOne.isEmpty() && stackTwo.isEmpty();
    }

    private Stack<Character> getNewStack(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            if(!stack.isEmpty() && str.charAt(i) == '#') stack.pop();
            else if(str.charAt(i) != '#') stack.push(str.charAt(i));
        }
        return stack;
    }

    public static void main(String[] args) {
        Problem844 problem844 = new Problem844();
        System.out.println(problem844.backspaceCompare("ab#c", "ad#c"));
        System.out.println(problem844.backspaceCompare("ab##", "c#d#"));
        System.out.println(problem844.backspaceCompare("a##c", "#a#c"));
        System.out.println(problem844.backspaceCompare("a#c", "b"));
    }
}
