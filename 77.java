class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<List<Integer>>();
        combine(1,n,k,new ArrayList<>());
        return result;
    }
    private void combine(int start,int end,int k,List<Integer> d){
        if(end-start+1<k) return;
        if(k==1){
            for(int i=start;i<=end;i++){
                List<Integer> temp = new ArrayList<>(d);
                temp.add(i);
                result.add(temp);
            }
        }else{
            combine(start+1,end,k,new ArrayList<>(d));
            List<Integer> temp = new ArrayList<>(d);
            temp.add(start);
            combine(start+1,end,k-1,temp);
        }
    }
}