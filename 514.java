//beats 95.06%
class Solution {
    List<List<Integer>> pos;
    int[][] cache;
    public int findRotateSteps(String ring, String key) {
        pos = new ArrayList<>();
        for(int i=0;i<26;i++) pos.add(new ArrayList<Integer>());
        cache = new int[ring.length()][key.length()];
        for(int i=0;i<ring.length();i++) pos.get(ring.charAt(i)-'a').add(i);
        return findRotateSteps(ring,key,0,0)+key.length();
    }
    private int findRotateSteps(String ring, String key, int rpos, int kpos){
        if(kpos==key.length()) return 0;
        if(cache[rpos][kpos]!=0) return cache[rpos][kpos];
        int res = Integer.MAX_VALUE;
        int n = ring.length();
        for(int k : pos.get(key.charAt(kpos)-'a')){
            int diff = Math.abs(rpos-k);
            int step = Math.min(diff,n-diff);
            res = Math.min(res,step+findRotateSteps(ring,key,k,kpos+1));
        }
        cache[rpos][kpos] = res;
        return res;
    }
}
//beats 13.58%
class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();int m = key.length();
        int[][] dp = new int[m+1][n];
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=0;k<n;k++){
                    if(ring.charAt(k)==key.charAt(i)){
                        int diff = Math.abs(j-k);
                        int step = Math.min(diff,n-diff);
                        dp[i][j] = Math.min(dp[i][j],step+dp[i+1][k]);
                    }
                }
            }
        }
        return dp[0][0]+m;
    }
    
}
