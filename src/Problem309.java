public class Problem309 {

    public int maxProfit(int[] prices) {
        int L = prices.length;
        if(L < 2) return 0;

        int has1_doNothing = -prices[0];
        int has1_Sell = 0;
        int has0_doNothing = 0;
        int has0_Buy = -prices[0];
        for(int i=1; i<L; i++) {
            has1_doNothing = has1_doNothing > has0_Buy ? has1_doNothing : has0_Buy;
            has0_Buy = -prices[i] + has0_doNothing;
            has0_doNothing = has0_doNothing > has1_Sell ? has0_doNothing : has1_Sell;
            has1_Sell = prices[i] + has1_doNothing;
        }
        return has1_Sell > has0_doNothing ? has1_Sell : has0_doNothing;
    }

    public static void main(String[] args){
        Problem309 problem309 = new Problem309();
        int[] prices = {2,1,2,1,0,1,2};
        System.out.println(problem309.maxProfit(prices));
    }
}
