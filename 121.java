class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0 || prices.length==1) return 0;
        int result = 0;
        int max_ending_here = 0;
        int temp;
        for(int i=1;i<prices.length;i++){
            temp = prices[i]-prices[i-1];
            max_ending_here = Math.max(temp,max_ending_here+temp);
            result = Math.max(result,max_ending_here);
        }
        return result;
    }
}