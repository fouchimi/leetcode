public class Problem877 {

    public boolean stoneGame(int[] piles) {
        int[] pq = new int[piles.length+1];
        int N = 0, sum = 0;
        for(int i = 0; i < piles.length; i++) {
            sum += piles[i];
            pq[++N] = piles[i];
            swim(N, pq);
        }

        int j = 0, firstTake = 0;
        while (N > 0) {
            int max = pq[1];
            exch(pq, 1, N--);
            sink(pq, 1, N);
            pq[N+1] = Integer.MIN_VALUE;
            if(j%2 == 0) firstTake += max;
            j++;
        }
        return firstTake > sum/2;
    }

    private void sink(int[]pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && less(pq, j, j+1)) j++;
            if(!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    private void swim(int k, int[] pq) {
        while(k > 1 && less(pq, k/2, k)) {
            exch(pq, k, k/2);
            k = k/2;
        }
    }

    private boolean less(int[] pq, int p, int q) {
        return pq[p] < pq[q];
    }

    private void exch(int[] pq, int p, int q) {
        int temp = pq[p];
        pq[p] = pq[q];
        pq[q] = temp;
    }

    public static void main(String[] args) {
        Problem877 problem877 = new Problem877();
        System.out.println(problem877.stoneGame(new int[]{5,3,4,5}));
    }
}
