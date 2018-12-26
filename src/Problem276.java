public class Problem276 {

    public int numWays(int n, int k)
    {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;

        int same = 0;
        int diff = k;
        int count = 1;

        while (count++ < n)
        {
            int diffTemp = diff;
            diff = same * (k-1) + diff * (k-1);
            same = diffTemp;
        }

        return same + diff;
    }

    public static void main(String[] args){
        Problem276 problem276 = new Problem276();
        System.out.println(problem276.numWays(3, 2));
        System.out.println(problem276.numWays(43, 2));
    }
}
