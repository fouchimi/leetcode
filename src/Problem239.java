import java.util.ArrayList;
import java.util.List;

public class Problem239 {

    int N = 0;
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int i = 0;
        List<Integer> list = new ArrayList<>();
        while (nums.length - i >= k) {
            int[] pq = new int[k + 1];
            for(int j = i; j < i + k; j++) {
                pq[++N] = nums[j];
                swim(pq, N);
            }
            list.add(pq[1]);
            N = 0;
            i++;
        }

        int[] result = new int[list.size()];
        int m = 0;
        for(int w : list) result[m++] = w;
        return result;
    }

    private void swim(int[] pq, int k) {
        while (k > 1 && less(pq, k/2, k)) {
            exch(pq, k/2, k);
            k = k/2;
        }
    }

    private boolean less(int[] pq, int p, int q) {
        return pq[p] < pq[q];
    }

    private void exch(int[] pq, int p, int q) {
        int temp = pq[q];
        pq[q] = pq[p];
        pq[p] = temp;
    }

    public static void main(String[] args) {
        Problem239 problem239 = new Problem239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] answer = problem239.maxSlidingWindow(nums, 3);
        for(int w : answer) System.out.print(w + " ");
        System.out.println();
    }
}
