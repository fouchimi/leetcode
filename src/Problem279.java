import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem279 {

    public int numSquares(int n) {

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++) {
                int current = ((LinkedList<Integer>) queue).remove(0);
                if(visited.contains(current)) continue;
                visited.add(current);
                int N = (int) Math.sqrt(current);
                for(int j = 1; j <= N; j++) {
                    int next = current - j*j;
                    if(next == 0) return step;
                    if(next > 0) {
                        ((LinkedList<Integer>) queue).addLast(next);
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Problem279 problem279 = new Problem279();
        System.out.println(problem279.numSquares(12));
    }
}
