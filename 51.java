class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solve(res,n,0,new int[n]);
        return res;
    }
    private void solve(List<List<String>> res,int n,int pos,int[] data){
        if(pos==n){
            //System.out.println(Arrays.toString(data));
            res.add(format(data));
            return;
        }
        for(int i=0;i<n;i++){
            data[pos] = i;
            boolean flag = false;
            for(int j=0;j<pos;j++){
                if(data[pos]==data[j]||Math.abs(pos-j)==Math.abs(data[pos]-data[j])){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                solve(res,n,pos+1,data);
            }
        }
    }
    private List<String> format(int[] data){
        List<String> list = new ArrayList<>();
        for(int d : data){
            char[] row = new char[data.length];
            Arrays.fill(row, '.');
            row[d] = 'Q';
            list.add(new String(row));
        }
        return list;
    }
}