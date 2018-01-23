class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> dp = new ArrayList<>();
        Arrays.sort(candidates);
        for(int i=1;i<=target;i++){
            List<List<Integer>> temp = new ArrayList<>();
            for(int j=0;j<candidates.length&&i>=candidates[j];j++){
                if(i==candidates[j]) temp.add(Arrays.asList(i));
                else{
                    for(List<Integer> l : dp.get(i-candidates[j]-1)){
                        if(candidates[j]>=l.get(l.size()-1)){
                            List t = new ArrayList();
                            t.addAll(l);t.add(candidates[j]);
                            temp.add(t);
                        }
                    }
                }
            }
            dp.add(temp);
        }
        return dp.get(target-1);
    }
}