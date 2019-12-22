class Solution {
public:
    int preimageSizeFZF(int K) {
        long left=0;
        long right=5L*(K+1);
        while(left<right){
            long mid = (right-left)/2+left;
            long cnt = 0;
            for(long i=5;mid/i>0;i*=5){
                cnt+=mid/i;
            }
            if(cnt==K) return 5;
            if(cnt<K) left=mid+1;
            else right=mid;
        }
        return 0;
    }
};