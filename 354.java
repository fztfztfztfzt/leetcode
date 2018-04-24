class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
        List<Integer> dp = new ArrayList<>();
        for(int i=0;i<envelopes.length;i++){
            int d = envelopes[i][1];
            int left = 0;
            int right = dp.size();
            while(left<right){
                int mid = (right-left)/2+left;
                if(dp.get(mid)<d) left = mid+1;
                else right = mid;
            }
            if(right>=dp.size()) dp.add(d);
            else dp.set(right,d);
        }
        return dp.size();
    }
}