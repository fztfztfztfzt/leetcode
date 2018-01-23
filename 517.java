class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum=0;
        for(int i : machines) sum+=i;
        if(sum%n!=0) return -1;
        int m = sum/n;
        int toLeft = 0;
        int toRight = 0;
        int result = 0;
        for(int i=0;i<n;i++){
            toRight = machines[i]-m-toLeft;
            result = Math.max(result,toLeft);
            result = Math.max(result,toRight);
            result = Math.max(result,toRight+toLeft);
            toLeft = -toRight;
        }
       return result;
    }
}