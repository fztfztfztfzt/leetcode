class Solution {
public:
    int minFlipsMonoIncr(string S) {
        int N = S.size();
        int one = 0;
        int res = INT_MAX;
        for(int i=0;i<N;i++) if(S[i]=='1') one++;
        int zero = N-one;
        int cur_one = 0;
        for(int i=0;i<=N;i++){
            int tmp = cur_one+(N-i)-(one-cur_one);
            res = min(res,tmp);
            //printf("%d %d \n",i,cur_one);
            if(i<N&&S[i]=='1') cur_one++;
        }
        return res;
    }
};
