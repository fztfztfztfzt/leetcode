class Solution {
public:
    vector<vector<int>> flipAndInvertImage(vector<vector<int>>& A) {
        vector<vector<int>> res;
        for(auto i : A){
            vector<int> tmp;
            for(int j=i.size()-1;j>=0;j--){
                if(i[j]==0) tmp.push_back(1);
                else tmp.push_back(0);
            }
            res.push_back(tmp);
        }
        return res;
    }
};
