class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->(a[1]==b[1]?a[0]-b[0]:a[1]-b[1]));
        int count = 0;
        int last = Integer.MIN_VALUE;
        for(int[] pair : pairs){
            if(pair[0]>last){
                last = pair[1];
                count++;
            }
        }
        return count;
    }
}