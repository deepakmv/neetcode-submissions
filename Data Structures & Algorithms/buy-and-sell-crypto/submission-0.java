class Solution {
    public int maxProfit(int[] prices) {

        int min = 101;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++) {
            if(prices[i]<min) {
                min = prices[i];
            }
            else {
                int profit = prices[i]-min;
                maxProfit = (profit > maxProfit) ? profit : maxProfit;
            }
        }
        return maxProfit;
    }
}
