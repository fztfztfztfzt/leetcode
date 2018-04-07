class Solution {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 ,23 ,29));
        for(int i=L;i<=R;i++){
            int c = 0;
            int p = i;
            while(p>0){
                c+=(p&1);
                p>>=1;
            }
            if(primes.contains(c)) count++;
        }
        return count;
    }
}