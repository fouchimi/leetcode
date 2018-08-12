import java.util.Stack;

public class Problem402 {

    public String removeKdigits(String num, int k) {

        if(num.length() == k || num.length() < k) return "0";

        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (k > 0 && i < num.length()) {
            if(stack.isEmpty()) stack.push(num.charAt(i));
            else {
                while (!stack.isEmpty() && stack.peek() > num.charAt(i) && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }
            i++;
        }

        while (i < num.length()) {
            stack.push(num.charAt(i));
            i++;
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.toString().isEmpty() ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Problem402 problem402 = new Problem402();
        System.out.println(problem402.removeKdigits("1432219", 3));
    }
}
