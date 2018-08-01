import java.util.Stack;

public class Problem640 {

    public String solveEquation(String equation) {

        Stack<Integer> operandStack = new Stack<>(), coefStack = new Stack<>();
        int i = 0, leftX = 0, leftK = 0;
        while (i < equation.length()) {
            if(equation.charAt(i) == 'x') {
                if(coefStack.isEmpty()) coefStack.push(1);
                else coefStack.push(coefStack.pop() + 1);
                i++;
            }else if(equation.charAt(i) == '-') {
                int k = i+1;
                if(k < equation.length() && equation.charAt(k) == 'x') {
                    if(coefStack.isEmpty()) coefStack.push(-1);
                    else coefStack.push(coefStack.pop() - 1);
                    i = k+1;
                }else if(k < equation.length() && (equation.charAt(k) >= '0' && equation.charAt(k) <= '9')){
                    int sum = 0;
                    while (k < equation.length() && equation.charAt(k) >= '0' && equation.charAt(k) <= '9') {
                        sum = 10 * sum + equation.charAt(k) - '0';
                        k++;
                    }
                    if(k < equation.length() && equation.charAt(k) == 'x') {
                        if(coefStack.isEmpty()) coefStack.push(-sum);
                        else coefStack.push(coefStack.pop() - sum);
                        i = k+1;
                    }else {
                        if(operandStack.isEmpty()) operandStack.push(-sum);
                        else operandStack.push(operandStack.pop() - sum);
                        i = k;
                    }

                }

            }else if(equation.charAt(i) == '+') {
                int k = i+1;
                if(k < equation.length() && equation.charAt(k) == 'x') {
                    if(coefStack.isEmpty()) coefStack.push(1);
                    else coefStack.push(coefStack.pop() + 1);
                    i = k+1;
                }else if(k < equation.length() && (equation.charAt(k) >= '0' && equation.charAt(k) <= '9')){
                    int sum = 0;
                    while (k < equation.length() && equation.charAt(k) >= '0' && equation.charAt(k) <= '9') {
                        sum = 10 * sum + equation.charAt(k) - '0';
                        k++;
                    }
                    if(k < equation.length() && equation.charAt(k) == 'x') {
                        if(coefStack.isEmpty()) coefStack.push(sum);
                        else coefStack.push(coefStack.pop() + sum);
                        i=k+1;
                    }else {
                        if(operandStack.isEmpty()) operandStack.push(+sum);
                        else operandStack.push(operandStack.pop() + sum);
                        i = k;
                    }
                }
            }else if(equation.charAt(i) >= '0' && equation.charAt(i) <= '9') {
                int sum = 0;
                while (i < equation.length() && equation.charAt(i) >= '0' && equation.charAt(i) <= '9') {
                    sum = 10 * sum + equation.charAt(i) - '0';
                    i++;
                }

                if(i < equation.length() && equation.charAt(i) == 'x') {
                    if(coefStack.isEmpty()) coefStack.push(sum);
                    else coefStack.push(coefStack.pop() + sum);
                    i++;
                }else {
                    if(operandStack.isEmpty()) operandStack.push(+sum);
                    else operandStack.push(operandStack.pop() + sum);
                }
            }else if(equation.charAt(i) == '=') {
                if(!coefStack.isEmpty()) leftX = coefStack.pop();
                if(!operandStack.isEmpty()) leftK = operandStack.pop();
                i++;
            }
        }

        int coef, K = 0;
        if(coefStack.isEmpty()) coef = leftX;
        else coef = leftX - coefStack.peek();
        if(operandStack.isEmpty()) K -= leftK;
        else K = operandStack.peek() - leftK;
        if(coef == 0 && !operandStack.isEmpty() && leftK == operandStack.peek()) return "Infinite solutions";
        if(!coefStack.isEmpty() && coefStack.peek() == leftX &&  K == 0) return "Infinite solutions";
        if(coef == 0 ) return "No solution";
        return "x=" + (K/coef);

    }


    public static void main(String[] args) {
        Problem640 problem640 = new Problem640();
        //System.out.println(problem640.solveEquation("1-x+x-x+x=1-x+x-x+x"));
        System.out.println(problem640.solveEquation("x=x"));
        /*System.out.println(problem640.solveEquation("2x=x"));
        System.out.println(problem640.solveEquation("2x+3x-6x=x+2"));
        System.out.println(problem640.solveEquation("x=x+2"));
        System.out.println(problem640.solveEquation("3x=33+22+11"));
        System.out.println(problem640.solveEquation("0x=0"));
        System.out.println(problem640.solveEquation("0=0x"));
        System.out.println(problem640.solveEquation("-x=-1"));*/
    }
}
