class Solution {
public:
    vector<int> numsSameConsecDiff(int N, int K) {
        vector<int> res;
        for(int i=1;i<10;i++) res.push_back(i);
        if(N==1){
            res.push_back(0);
            return res;
        }
        if(K==0){
            int mul = 0;
            for(int i=0;i<N;i++) mul=mul*10+1;
            for(int i=0;i<res.size();i++) res[i] = res[i]*mul;
            return res;
        }
        return numsSameConsecDiff(N,K,1,res);
    }
private:
    vector<int> numsSameConsecDiff(int N, int K, int num, vector<int>& cur){
        if(N==num) return cur;
        vector<int> res;
        for(auto n : cur){
            int tmp = n%10;
            if(tmp-K>=0) res.push_back(n*10+tmp-K);
            if(tmp+K<=9) res.push_back(n*10+tmp+K);
        }
        return numsSameConsecDiff(N,K,num+1,res);
    }
};
