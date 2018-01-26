class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if(num.length()==0) return result;
        char[] path = new char[num.length()*2+1];
        char[] d = num.toCharArray();
        long n = 0;
        for(int i=0;i<d.length;i++){
            n = n*10+(d[i]-'0');
            path[i] = d[i];
            dfs(result,target,path,i+1,0,n,d,i+1);
            if(n==0) break;
        }
        return result;
    }
    private void dfs(List<String> result,int target,char[] path,int len,long left,long cur,char[] num,int pos){
        if(pos==num.length){
            if(left+cur==target) result.add(new String(path,0,len));
            return;
        }
        int j = len+1;
        long n = 0;
        for(int i=pos;i<num.length;i++){
            n = n*10+(num[i]-'0');
            path[j++] = num[i];
            path[len] = '+';
            dfs(result,target,path,j,left+cur,n,num,i+1);
            path[len] = '-';
            dfs(result,target,path,j,left+cur,-n,num,i+1);
            path[len] = '*';
            dfs(result,target,path,j,left,cur*n,num,i+1);
            if(n==0) break;
        }
    }
}