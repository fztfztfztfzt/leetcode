class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        long n = (long)Math.ceil((Math.sqrt(1+8*(long)target)-1.0)/2.0);
        long sum = (n+1)*n/2;
        if(sum==target) return (int)n;
        long res = sum - target;
        if((res&1)==0){
            return (int)n;
        }else{
            return (int)n+(((n&1)==0)?1:2);
        }
    }
}