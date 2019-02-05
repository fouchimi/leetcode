public class Problem371 {

    public int getSum(int a, int b) {

        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }


    public static void main(String[] args) {
        Problem371 problem371 = new Problem371();
        System.out.println(problem371.getSum(1, 10));
        System.out.println(problem371.getSum(2, 3));
    }

}
