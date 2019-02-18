public class Problem357 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0 || n > 10) return 0;
        if(n == 1) return 10;
        int count = 10, mult = 9, result = 9;
        for(int i = 1; i < n; i++) {
            result *= mult;
            mult--;
            count += result;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem357 problem357 = new Problem357();
        System.out.println(problem357.countNumbersWithUniqueDigits(2));
    }
}
