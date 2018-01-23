class Solution {
    public int calPoints(String[] ops) {
        int len = ops.length;
        int[] goal = new int[len];
        int n = -1;
        int sum = 0;
        for(String cmd : ops){
            if(cmd.equals("D")){
                goal[n+1]=goal[n]*2;
                sum += goal[n+1];
                n++;
            }else if(cmd.equals("C")){
                sum-=goal[n];
                n--;
            }else if(cmd.equals("+")){
                n++;
                goal[n] = goal[n-1]+goal[n-2];
                sum+=goal[n];
            }else{
                n++;
                goal[n] = Integer.parseInt(cmd);
                sum+=goal[n];
            }
        }
        return sum;
    }
}