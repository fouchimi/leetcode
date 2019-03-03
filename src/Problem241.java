import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem241 {

    Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        // check memo
        List<Integer> result = memo.get(input);
        if(result != null) return result;
        result = new ArrayList<>();
        if(isNumber(input)) {
            result.add(Integer.parseInt(input));
            memo.put(input, result);
            return result;
        }
        for(int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            if(ch == '*' || ch == '+' || ch == '-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1, len));
                for(Integer iLeft : left) {
                    for(Integer rRight : right) {
                        switch (ch) {
                            case '+': result.add(iLeft + rRight); break;
                            case '-': result.add(iLeft - rRight); break;
                            case '*': result.add(iLeft * rRight); break;
                        }
                    }
                }
            }
        }
        memo.put(input, result);
        return result;
    }

    private boolean isNumber(String s) {
        for(char ch : s.toCharArray()) {
            if(!Character.isDigit(ch)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem241 problem241 = new Problem241();
        System.out.println(problem241.diffWaysToCompute("2*3-4*5"));
    }
}
