public class Problem256 {

    public int minCost(int[][] costs) {
        if(costs == null || costs.length  == 0) return 0;
        int n = costs.length, r = 0, g = 0, b = 0;
        for (int i = 0; i < n; i++) {
            int rr = r, bb = b, gg = g;
            r = costs[i][0] + Math.min(bb, gg);
            b = costs[i][1] + Math.min(rr, gg);
            g = costs[i][2] + Math.min(rr, bb);
        }
        return Math.min(r, Math.min(b, g));
    }

    public static void main(String[] args) {
        Problem256 problem256 = new Problem256();
        int[][] array = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(problem256.minCost(array));
    }
}
