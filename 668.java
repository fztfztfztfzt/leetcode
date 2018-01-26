class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n+1;
        while(low<high){
            int mid = (high-low)/2+low;
            int t = count(mid,m,n);
            if(t>=k) high = mid;
            else low = mid+1;
        }
        return high;
    }
    private int count(int mid,int m,int n){
        int count = 0;
        for(int i=1;i<=m;i++){
            int temp = Math.min(mid/i,n);
            count += temp;
        }
        return count;
    }
}