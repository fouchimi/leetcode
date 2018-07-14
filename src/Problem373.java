public class Problem373 {



    private void swim(int k) {

        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private boolean less(int p, int q) {
        return p < q;
    }

    private void exch(int p, int q){

    }
}
