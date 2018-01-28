class Solution {
    public int findIntegers(int num) {
        int[] f = new int[32];
        f[0] = 1; f[1] = 2;
        for(int i=2;i<32;i++){
            f[i] = f[i-1]+f[i-2];
        }
        
        int k=31;
        int res = 0;
        boolean pre = false;
        while(k>=0){
            if((num&(1<<k))!=0){
                res += f[k];
                if(pre) return res;
                pre = true;
            }else pre = false;
            k--;
        }
        return res+1;
    }
}