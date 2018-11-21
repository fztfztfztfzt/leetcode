class Solution {
public:
    vector<vector<int>> largeGroupPositions(string S) {
        int start = 0;
        int end = 1;
        vector<vector<int>> res;
        while(end<S.size()){
            while(end<S.size()&&S[end]==S[start]) end++;
            if(end-start>=3){
                vector<int> tmp;
                tmp.push_back(start);
                tmp.push_back(end-1);
                res.push_back(tmp);
            }
            start = end;
            end = end+1;
        }
        return res;
    }
};
