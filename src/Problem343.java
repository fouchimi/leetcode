public class Problem343 {

    public int integerBreak(int n) {
        if(n == 2) return 1;
        int max = Integer.MIN_VALUE;
        int i = 2;
        while (i < n) {
            int k= 1, m = n;
            while (m-i > 0 ) {
                max = Math.max(max, i * k * (m-i));
                m -= i;
                k *= i;
            }
            i++;
        }
        return max;
    }

    public static void main(String[] args) {
        Problem343 problem343 = new Problem343();
        System.out.println(problem343.integerBreak(10));
    }

}
