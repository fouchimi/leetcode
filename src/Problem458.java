public class Problem458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int factor = minutesToTest / minutesToDie;

        return buckets / factor;
    }

    public static void main(String[] args) {
        Problem458 problem458 = new Problem458();
        System.out.println(problem458.poorPigs(1000, 15, 60));
    }
}
