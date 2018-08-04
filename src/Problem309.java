public class Problem309 {

    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
            int p = i, current = prices[i];
            while (p < prices.length) {
                int profit = 0;
                for(int j = p+1; j < prices.length; ) {
                    if(prices[j] > current) {
                        profit += prices[j]-current;
                        j = j+2;
                    }else j++;
                }
                p++;
                max = Math.max(max, profit);
            }
        }
        return max;
    }

    public static void main(String[] args){
        Problem309 problem309 = new Problem309();
        int[] prices = {1,2,3,0,2};
        System.out.println(problem309.maxProfit(prices));
    }
}
