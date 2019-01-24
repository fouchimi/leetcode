import java.util.HashMap;
import java.util.Map;

public class Problem509 {

    public int fib(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(N, map);
    }

    private int helper(int N, Map<Integer, Integer> map) {
        if(N <= 0) return 0;
        if(N == 1) return 1;
        if(map.containsKey(N)) return map.get(N);
        int result = helper(N-1, map) + helper(N-2, map);
        map.put(N, result);
        return result;
    }

    public static void main(String[] args) {
        Problem509 problem509 = new Problem509();
        System.out.println(problem509.fib(5));
    }
}
