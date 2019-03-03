import java.util.PriorityQueue;

public class Problem703 {
    PriorityQueue<Integer> minHeap;
    int K;
    public Problem703(int k, int[] nums) {
        K = k;
        minHeap = new PriorityQueue<>(K+1);
        for(int n : nums)
            add(n);
    }

    public int add(int val) {
        minHeap.offer(val);
        while (minHeap.size() > K) minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Problem703 problem703 = new Problem703(1, new int[]{});
        System.out.println(problem703.add(-3));
        System.out.println(problem703.add(-2));
        System.out.println(problem703.add(-4));
        System.out.println(problem703.add(0));
        System.out.println(problem703.add(4));
    }
}
