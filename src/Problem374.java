public class Problem374 {

    public int guessNumber(int n) {
        return guessNumberUtil(1, n);
    }

    private int guessNumberUtil(int lo, int hi) {
        if(lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        int val = guess(mid);
        if(val < 0) return guessNumberUtil(lo, mid-1);
        else if(val > 0) return guessNumberUtil(mid+1, hi);
        return mid;
    }

    private static int guess(int val) {
        int magicNumber = 6;
        if(val > magicNumber) return 1;
        else if(val < magicNumber) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Problem374 problem374 = new Problem374();
        System.out.println(problem374.guessNumber(10));
    }
}
