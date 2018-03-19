class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int sell=0;
        int buy=-prices[0];
        int presell=0;
        for(int i=1;i<prices.length;i++){
            int prebuy = buy;
            buy = Math.max(buy,presell-prices[i]);
            presell = sell;
            sell = Math.max(sell,prebuy+prices[i]);
        }
        return sell;
    }
}