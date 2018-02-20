class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while(k>0){
            int step = 0;
            long start = cur;
            long end = cur+1;
            while(start<=n){
                step+=Math.min(n+1,end)-start;
                start*=10;
                end*=10;
            }
            if(step<=k){
                k-=step;
                cur++;
            }else{
                cur*=10;
                k--;
            }
        }
        return cur;
    }
}