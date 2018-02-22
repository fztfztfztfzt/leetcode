class Solution {
    public int divide(int dividend, int divisor) {
        int sign = ((dividend>0)^(divisor>0))?-1:1;
        if(divisor==0) return Integer.MAX_VALUE;
        long ldivisor = Math.abs((long)divisor);
        long ldividend = Math.abs((long)dividend);
        if(ldivisor>ldividend) return 0;
        long res = ldivide(ldividend,ldivisor);
        if(res>=Integer.MAX_VALUE) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
        return (int)(sign*res);
    }
    private long ldivide(long dividend,long divisor){
        if(dividend<divisor) return 0;
        long sum = divisor;
        long res = 1;
        while((sum+sum)<dividend){
            sum<<=1;
            res<<=1;
        }
        return res+ldivide(dividend-sum,divisor);
    }
}