class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(selfDividingNumbers(i)) result.add(i);
        }
        return result;
    }
    private boolean selfDividingNumbers(int num){
        int temp = num;
        while(temp>0){
            int c = temp%10;
            if(c==0||num%c!=0) return false;
            temp /= 10;
        }
        return true;
    }
}