class Solution {
public:
    int consecutiveNumbersSum(int N) {
        int res = 1;
        int end = sqrt(2*N);
        --N;
        for(int i=2;i<=end;++i){
            if(N%i==0) ++res;
            N-=i;
        }
        return res;
    }
};
