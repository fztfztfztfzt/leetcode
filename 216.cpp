class Solution {
public:
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> res;
        vector<int> cur;
        combinationSum3(res,cur,k,n,1);
        return res;
    }
private:
    void combinationSum3(vector<vector<int>>& res, vector<int>& cur, int k, int n,int start) {
        if(k==0&&n==0){
            res.push_back(cur);
            return;
        }
        if(start==10) return;
        combinationSum3(res,cur,k,n,start+1);
        cur.push_back(start);
        combinationSum3(res,cur,k-1,n-start,start+1);
        cur.pop_back();
    }
};