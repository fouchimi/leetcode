import java.util.Stack;

public class Problem640 {

    public String solveEquation(String equation) {
        Stack<Integer> operandStack = new Stack<>(), coefStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();
        int i = 0, leftSideX = 0, leftSideConst = 0;
        while (i < equation.length()) {
            if(equation.charAt(i) == 'x')  {
                if(i-1 >= 0 && equation.charAt(i-1) == '-' && coefStack.isEmpty()) coefStack.push(-1);
                else if(coefStack.isEmpty()) coefStack.push(1);
                else if(i-1 >= 0 && equation.charAt(i-1) == '-' && !coefStack.isEmpty()) coefStack.push(coefStack.pop() - 1);
                else coefStack.push(coefStack.pop() + 1);
                i++;
            }
            else if(equation.charAt(i) >= '0' && equation.charAt(i) <= '9') {
                int sum = equation.charAt(i) - '0',  k = i+1;
                boolean flag = false;
                while (k < equation.length() && equation.charAt(k) >= '0' && equation.charAt(k) <= '9') {
                    sum = 10 * sum + equation.charAt(k) - '0';
                    flag = true;
                    k++;
                }
                if(k < equation.length() && equation.charAt(k) == 'x') {
                    if(coefStack.isEmpty()) coefStack.push(Integer.parseInt(equation.substring(i, k)));
                    else {
                        int peek = coefStack.pop();
                        if(i-1 >= 0 && equation.charAt(i-1) == '-') coefStack.push(peek - Integer.parseInt(equation.substring(i, k)));
                        else coefStack.push(peek + Integer.parseInt(equation.substring(i, k)));
                    }
                    i = k+1;
                }else {
                    if(operandStack.isEmpty() && i-1 >= 0 && equation.charAt(i-1) == '-') operandStack.push(-sum);
                    else if(operandStack.isEmpty()) operandStack.push(sum);
                    else {
                        int peek = operandStack.pop();
                        char ch = operatorStack.pop();
                        if(ch == '-') operandStack.push(peek - sum);
                        else operandStack.push(peek + sum);
                    }
                    if(flag) i = k;
                    else i++;
                }
            }else if(equation.charAt(i) == '+' || equation.charAt(i) == '-') operatorStack.push(equation.charAt(i++));
            else if(equation.charAt(i) == '=') {
                if(!coefStack.isEmpty()) leftSideX = coefStack.pop();
                if(!operandStack.isEmpty()) leftSideConst = operandStack.pop();
                i++;
            }
        }

        if(!coefStack.isEmpty() && leftSideX != coefStack.peek()) {
            int x = leftSideX - coefStack.pop(), c = 0;
            if(!operandStack.isEmpty()) c = operandStack.pop() - leftSideConst;
            else c -=  leftSideConst;
            if(x == 0) return "No solution";
            c /= x;
            return  "x=" + c;
        }else if(leftSideX == 0 && !coefStack.isEmpty()) {
            int x = coefStack.pop(), c;
            if(!operandStack.isEmpty()) c = leftSideX - operandStack.pop();
            else c = leftSideConst;
            if(x == 0) return "No solution";
            c /= x;
            return "x=" + c;
        }else if(leftSideX != 0 && coefStack.isEmpty()) {
            int x = leftSideX, c = 0;
            if(!operandStack.isEmpty()) c = operandStack.pop() - leftSideConst;
            else c -= leftSideConst;
            c /= x;
            return "x=" + c;
        }else if(!coefStack.isEmpty() && leftSideX == coefStack.peek() && leftSideConst == 0 && operandStack.isEmpty()) return "Infinite solutions";
        else return "No solution";

    }

    public static void main(String[] args) {
        Problem640 problem640 = new Problem640();
        /*System.out.println(problem640.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(problem640.solveEquation("x=x"));
        System.out.println(problem640.solveEquation("2x=x"));
        System.out.println(problem640.solveEquation("2x+3x-6x=x+2"));
        System.out.println(problem640.solveEquation("x=x+2"));
        System.out.println(problem640.solveEquation("3x=33+22+11"));
        System.out.println(problem640.solveEquation("0x=0"));
        System.out.println(problem640.solveEquation("0=0x"));*/
        System.out.println(problem640.solveEquation("-x=-1"));
    }
}
