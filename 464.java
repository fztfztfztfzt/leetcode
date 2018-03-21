class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int total = (maxChoosableInteger+1)*maxChoosableInteger/2;
        int[] map = new int[1<<maxChoosableInteger];
        if(total<desiredTotal) return false;
        if(total==desiredTotal&&maxChoosableInteger%2==1) return true;
        return dfs(maxChoosableInteger,desiredTotal,0,map);
    }
    private boolean dfs(int max, int total, int state, int[] map) {
        if(map[state]!=0) return map[state]==1;
        for(int i=1;i<=max;i++){
            int mask = 1<<(i-1);
            if((mask&state)==0){
                if(total<=i||!dfs(max,total-i,state^mask,map)){
                    map[state]=1;
                    return true;
                }
            }
        }
        map[state]=2;
        return false;
    }
}