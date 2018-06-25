
public class Problem122 {


    public int maxProfit(int[] prices) {

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, maxProfit = 0, sum = 0;
        for(int i = 0; i < prices.length; i++) {
            min1 = Math.min(min1, prices[i]);
            min2 = Math.min(min2, prices[i]);
            if(prices[i] > min1) maxProfit = Math.max(maxProfit, prices[i]-min1);
            if(prices[i] > min2) {
                sum += prices[i] - min2;
                min2 = prices[i];
            }

        }
        return Math.max(maxProfit, sum);
    }

    public static void main(String[] args) {
        Problem122 problem122 = new Problem122();
        int[] prices = {1,2,3,4,5};
        System.out.println(problem122.maxProfit(prices));
    }
}
