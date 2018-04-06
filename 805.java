class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for(int a : A) sum+=a;
        Arrays.sort(A);
        for(int i=1;i<(A.length/2)+1;i++){
            if((sum*i)%A.length==0){
                if(dfs(A,(sum*i)/A.length,i,0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int[] A,int target,int num,int pos){
        if(target==0&&num==0) return true;
        if(target<=0||num<=0) return false;
        if(A[pos]*num>target) return false;
        for(int i=pos;i<A.length-num+1;i++){
            if(i>pos&&A[i]==A[i-1]) continue;
            if(dfs(A,target-A[i],num-1,i+1)) return true;
        }
        return false;
    }
}