class Solution {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int F = 0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
            F+=(i*A[i]);
        }
        int max = F;
        for(int i=1;i<A.length;i++){
            F = F-sum+A.length*A[i-1];
            max = Math.max(max,F);
        }
        return max;
    }
}