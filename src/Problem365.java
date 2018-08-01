public class Problem365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == z || y == z || x + y == z) return true;
        return z%gcd(Math.min(x, y), Math.max(x, y)) == 0;
    }

    private int gcd(int a, int b) {
        if(a == 0) return b;
        else if(a == 1) return 1;
        else return gcd(b%a, a);
    }


    public static void main(String[] args) {
        Problem365 problem365 = new Problem365();
        System.out.println(problem365.canMeasureWater(3, 5, 4));
    }
}
