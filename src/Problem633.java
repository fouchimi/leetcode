
public class Problem633 {

    public boolean judgeSquareSum(int c) {
        int min = 0;
        int max = (int) Math.sqrt(c);
        while (min <= max) {
            if((min * min) + (max * max) < c) min++;
            else if((min * min) + (max * max) > c) max--;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem633 problem633 = new Problem633();
        System.out.println(problem633.judgeSquareSum(5));
        System.out.println(problem633.judgeSquareSum(1000));
        System.out.println(problem633.judgeSquareSum(1000000000));
    }
}
