class Solution {
    public String smallestGoodBase(String n) {
        long nn = Long.parseLong(n);
        int p = 60;
		while((1<<p)>=nn) p--;
        for(int x=p+1;x>=2;x--){
            long s=2;
            long e=(long)(Math.pow(nn,1.0/x)+1);
            while(s<e){
                long mid = s + (e - s) / 2;
                long sum = 0, cur = 1;
                for (int i = 0; i <= x; i++) {
                    sum += cur;
                    cur *= mid;
                }
                if (sum == nn) return ""+mid;
                else if (sum > nn) e = mid;
                else s = mid + 1;
            }
        }
        return String.valueOf(nn - 1);
    }
}