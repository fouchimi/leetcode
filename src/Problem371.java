public class Problem371 {

    public int getSum(int a, int b) {

        return helper(a, 2)  + helper(b, 2);
    }

    private int helper(int val, int num) {
        if(val == 0 || val == 1) return val;
        if(val%2 == 0) return num + helper(val/2, num);
        return 1 + num + helper(val/2, num);
    }

    public static void main(String[] args) {
        Problem371 problem371 = new Problem371();
        System.out.println(problem371.getSum(1, 10));
    }

}
