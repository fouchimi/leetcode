import java.util.ArrayList;
import java.util.List;

public class Problem373 {

    Pair[] pairsArr = null;
    int N = 0;
    private class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ")";
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        pairsArr = new Pair[nums1.length * nums2.length + 1];
        int index = 1;
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                Pair pair = new Pair(nums1[i], nums2[j]);
                pairsArr[index++] = pair;
                N++;
                swim(N);
            }
        }

        List<Pair> list = new ArrayList<>();

        while (k > 0 && N > 0) {
            Pair minPair = pairsArr[1];
            pairsArr[1] = pairsArr[N--];
            pairsArr[N+1] = null;
            sink(1);
            list.add(minPair);
            k--;
        }

        //for(Pair pair : list) System.out.print(pair + " ");

        List<int[]> l = new ArrayList<>();
        for(Pair pair : list) {
            int[] p = new int[2];
            p[0] = pair.x;
            p[1] = pair.y;
            l.add(p);
        }

        return l;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private boolean greater(int p, int q) {
        Pair firstPair = pairsArr[p], secondPair = pairsArr[q];
        return (firstPair.x + firstPair.y) > (secondPair.x + secondPair.y);
    }

    private void exch(int p, int q){
        Pair temp = pairsArr[p];
        pairsArr[p] = pairsArr[q];
        pairsArr[q] = temp;
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if(j < N && greater(j, j+1)) j++;
            if(!greater(k, j)) break;
            exch(j, k);
            k = j;
        }
    }

    public static void main(String[] args) {
        Problem373 problem373 = new Problem373();
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        List<int[]> resultList = problem373.kSmallestPairs(nums1, nums2, 3);
        for(int[] arr : resultList) {
            for(int w : arr) System.out.print(w + " ");
            System.out.println();
        }
    }
}
