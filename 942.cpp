class Solution {
public:
    vector<int> diStringMatch(string S) {
        int low = 0;
        int high = S.size();
        vector<int> res;
        for(int i=0;i<S.size();i++){
            if(S[i]=='I'){
                res.push_back(low);
                low++;
            }else{
                res.push_back(high);
                high--;
            }
        }
        res.push_back(low);
        return res;
    }
};
