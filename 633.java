class Solution {
    public boolean judgeSquareSum(int c) {
        if(c<0) return false;
        int start = 0;int end = (int)Math.sqrt(c);
        while(start<=end){
            int sum=start*start+end*end;
            if(sum>c) end--;
            else if(sum<c) start++;
            else return true;
        }
        return false;
    }
}