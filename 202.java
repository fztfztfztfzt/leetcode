class Solution {
    public boolean isHappy(int n) {
        HashMap map = new HashMap();
        while(true){
            n = cal(n);
            if(n==1) return true;
            if(map.containsKey(n)) return false;
            map.put(n,n);
        }
    }
    private int cal(int n){
        int s = 0;
        while(n!=0){
            s+=(n%10)*(n%10);
            n = n/10;
        }
        return s;
    }
}