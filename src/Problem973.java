import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem973 {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((first, second) -> {
            double firstDist = Math.sqrt((first[0] * first[0]) + (first[1] * first[1]));
            double secondDist = Math.sqrt((second[0] * second[0]) + (second[1] * second[1]));
            return Double.compare(firstDist, secondDist);
        });
        priorityQueue.addAll(Arrays.asList(points));
        int[][] result = new int[K][K];
        int i = 0;
        while ( K > 0) {
            result[i] = priorityQueue.poll();
            i++;
            K--;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem973 problem973 = new Problem973();
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int K = 2;
        int[][] res = problem973.kClosest(points, K);
        for(int i = 0; i < res.length; i++) {
           int[] tuple = res[i];
            System.out.print("[" + tuple[0] + "," + tuple[1] + "]" + " ");
        }
    }
}
