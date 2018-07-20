import java.util.Stack;

public class Problem186 {

    public void reverseWords(char[] str) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < str.length) {
            StringBuilder sb = new StringBuilder();
            while (i < str.length && str[i] != ' ') sb.append(str[i++]);
            stack.push(sb.toString());
            i++;
        }
        i=0;
        while (!stack.isEmpty()){
            String current = stack.pop();
            int N = current.length();
            int j = 0;
            while (N > 0) {
                str[i] = current.charAt(j);
                N--;
                i++;
                j++;
            }
            if(i + 1 < str.length ) str[i++] = ' ';
        }

        for(int k = 0; k < str.length; k++) {
            System.out.print(str[k]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem186 problem186 = new Problem186();
        char[] arr = {'t','h','e',' ','s','k','y',' ','i','s',' ', 'b','l','u','e'};
        problem186.reverseWords(arr);
    }
}
