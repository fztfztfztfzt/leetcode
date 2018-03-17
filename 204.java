class Solution {
    public int countPrimes(int n) {
        boolean[] num = new boolean[n];
        int count = 0;
        for(int i=2;i<n;i++){
            if(num[i]==false){
                count++;
                for(int j=i*2;j<n;j+=i){
                    num[j]=true;
                }
            }
        }
        return count;
    }
}