import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CountingSquarePairs {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(!(obj instanceof Pair)) return false;
            Pair pair = (Pair) obj;
            return this.x + this.y == pair.x + pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }

    public int countSquarePairs(int[] a) {
        List<Pair> pairList = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            for(int j = i+1; j < a.length; j++) {
                Pair newPair = new Pair(a[i], a[j]);
                int sum = a[i] + a[j];
                if(isPerfectSquare(sum) && !pairList.contains(newPair)) pairList.add(newPair);
            }
        }

        return pairList.size();

    }

    private boolean isPerfectSquare(int num) {
        return isPerfectSquareUtil(0, num, num);
    }

    private boolean isPerfectSquareUtil(int lo, int hi, int val) {
        if (lo > hi) return false;
        int mid = lo + (hi-lo)/2;
        int square = mid * mid;
        if (val == square) return true;
        else if(square > val) return  isPerfectSquareUtil(lo, mid-1, val);
        else return isPerfectSquareUtil(mid+1, hi, val);
    }

    public static void main(String[] args) {

        CountingSquarePairs countingSquarePairs = new CountingSquarePairs();
        int[] a = {11, 5, 4, 20};
        System.out.println(countingSquarePairs.countSquarePairs(a));

    }
}
