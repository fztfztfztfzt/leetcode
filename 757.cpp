static const int __ = []() {
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);
    std::cout.tie(nullptr);
    return 0;
}();

class Solution {
public:
    int intersectionSizeTwo(vector<vector<int>>& intervals) {
        int res = 0, p1 = -1, p2 = -1;
        sort(intervals.begin(),intervals.end(),compare);
        for(auto interval : intervals){
            if(interval[0]<=p2) continue;
            else if(interval[0]<=p1){
                res++;
                p2 = p1;
                p1 = interval[1];
            }else{
                res+=2;
                p1 = interval[1];
                p2 = interval[1]-1;
            }
        }
        return res;
    }
private:
    int static compare(vector<int> a, vector<int> b){
        return a[1]<b[1]||((a[1]==b[1])?a[0]>b[0]:false);
    }
};
