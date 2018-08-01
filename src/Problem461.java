public class Problem461 {


    public int hammingDistance(int x, int y) {

        int distance = 0;
        int c = x ^ y;
        while (c > 0) {
            int lastbit = c & 1;
            if(lastbit == 1) distance++;
            c = c >> 1;
        }

        return distance;
    }

    public static void main(String[] args) {
        Problem461 problem461 = new Problem461();
        System.out.println(problem461.hammingDistance(1, 4));
    }
}
