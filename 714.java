class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold=-prices[0];
        int cash=0;
        for(int i=1;i<prices.length;i++){
            int temp = cash;
            cash = Math.max(cash,hold+prices[i]-fee);
            hold = Math.max(hold,temp-prices[i]);
        }
        return cash;
    }
}