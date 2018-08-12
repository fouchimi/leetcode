public class Problem215 {

    int[] pq;
    int N = 0;
    public int findKthLargest(int[] nums, int k) {

        pq = new int[nums.length + 1];
        int index = 1;
        for(int i = 0; i < nums.length; i++) {
            pq[index++] = nums[i];
            N++;
            swim(N);
        }

        int minvalue = Integer.MIN_VALUE;
        while (k > 0) {
            minvalue = pq[1];
            pq[1] = pq[N--];
            pq[N+1] = '\0';
            sink(1);
            k--;
        }

        return minvalue;
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(less(j, k)) break;
            exch(j, k);
            k = j;
        }
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private boolean less(int p, int q) {
        return pq[p] < pq[q];
    }

    private void exch(int p, int q) {
        int temp = pq[p];
        pq[p] = pq[q];
        pq[q] = temp;
    }

    public static void main(String[] args) {
        Problem215 problem215 = new Problem215();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(problem215.findKthLargest(nums, 2));
    }
}
