class Solution {
    public int minSteps(int n) {
        int k=2;
        int sum = 0;
        while(k<=n){
            if(n==1) break;
            if((n%k)==0){
                sum+=k;
                n /= k;
            }else k++;
        }
        return sum;
    }
}