class Solution {
public:
    vector<vector<int>> outerTrees(vector<vector<int>>& points) {
        int n = points.size();
        sort(points.begin(),points.end(),compare);
        vector<vector<int>> res;
        for(int i=0;i<n;++i){
            while(res.size()>1&&cross(res[res.size()-2],res.back(),points[i])<0) res.pop_back();
            res.push_back(points[i]);
        }
        if(res.size()==n) return res;
        for(int i=n-2;i>=0;--i){
            while(res.size()>1&&cross(res[res.size()-2],res.back(),points[i])<0) res.pop_back();
            res.push_back(points[i]);
        }
        res.pop_back();
        return res;
    }
private:
    static bool compare(vector<int>& a,vector<int>& b) {
        return a[0]<b[0]||(a[0]==b[0]&&a[1]<b[1]);
    }
    int cross(vector<int>& a,vector<int>& b,vector<int>& c){
        return (b[0]-a[0])*(c[1]-b[1])-(b[1]-a[1])*(c[0]-b[0]);
    }
};
