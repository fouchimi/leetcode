import java.util.Stack;

public class Problem150 {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for(String str : tokens) {
            if(isSymbol(str.charAt(0)) && str.length() == 1) {
                int first  = stack.pop();
                int second = stack.pop();
                stack.push(compute(second, first, str.charAt(0)));

            }
            else  stack.push(Integer.parseInt(str));

        }
        return stack.pop();
    }

    private boolean isSymbol(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    private int compute(int p, int q, char c) {
        switch (c) {
            case '/' : return p/q;
            case '*' : return p*q;
            case '-' : return p-q;
            default : return p+q;
        }
    }

    public static void main(String[] args) {
        Problem150 problem150 = new Problem150();
        String[] strs = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(problem150.evalRPN(strs));
    }
}
