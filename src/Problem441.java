public class Problem441 {

    public int arrangeCoins(int n) {
        int i = 1, count = 0;
        while (n >= i) {
            count++;
            n = n - i;
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem441 problem441 = new Problem441();
        System.out.println(problem441.arrangeCoins(5));
        System.out.println(problem441.arrangeCoins(8));
    }
}
