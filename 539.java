class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[timePoints.size()];
        int n = 0;
        for(String s : timePoints){
            String[] temp = s.split(":");
            int t = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            time[n++] = t;
        }
        Arrays.sort(time);
        int min = Integer.MAX_VALUE;
        int temp;
        for(int i=0;i<n;i++){
            if(i==0) temp = time[n-1]-time[0]; 
            else temp = time[i]-time[i-1];
            temp = Math.min(temp,1440-temp);
            min = Math.min(min,temp);
        }
        return min;
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] time = new boolean[24*60];
        for(String s : timePoints){
            String[] temp = s.split(":");
            int t = Integer.parseInt(temp[0])*60+Integer.parseInt(temp[1]);
            if(time[t]) return 0;
            else time[t]=true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        for(int i=0;i<24*60;i++){
            if(time[i]){
                if(first!=Integer.MAX_VALUE){
                    min=Math.min(min,i-prev);
                }
                first = Math.min(first,i);
                last = Math.max(last,i);
                prev = i;
            }
        }
        System.out.print(min);
        return Math.min(min,1440-(last-first));
    }
}