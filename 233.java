class Solution {
    public int countDigitOne(int n) {
        long count = 0;
        for(long i=1;i<=n;i*=10){
            long left = n/(i*10);
            long mid = (n/i)%10;
            long right = n%i;
            if(mid==0) count+=left*i;
            else if(mid==1) count+=left*i+right+1;
            else count+=(left+1)*i;
        }
        return (int)count;
    }
}