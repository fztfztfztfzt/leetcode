class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length==0) return 0;
        int total = 0;
        int begin=timeSeries[0];
        for(int time : timeSeries){
            total+=Math.min(duration,time-begin);
            begin=time;
        }
        return total+duration;
    }
}