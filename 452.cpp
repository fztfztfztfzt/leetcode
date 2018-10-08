class Solution {
public:
    int findMinArrowShots(vector<pair<int, int>>& points) {
        if(points.empty()) return 0;
        sort(points.begin(),points.end());
        int end = points[0].second;
        int res = 1;
        for(int i=0;i<points.size();i++){
            if(points[i].first<=end){
                end = min(end,points[i].second);
            }else{
                ++res;
                end = points[i].second;
            }
        }
        return res;
    }
};
