public class Problem121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            if(prices[i] > min) {
                maxProfit = Math.max(maxProfit, prices[i]-min);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Problem121 problem121 = new Problem121();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(problem121.maxProfit(prices));
    }
}
