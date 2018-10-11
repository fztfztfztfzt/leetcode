class Solution {
public:
    vector<int> constructRectangle(int area) {
        int W = floor(sqrt(area));
        while(area%W!=0) W--;
        vector<int> res;
        res.push_back(area/W);
        res.push_back(W);
        return res;
    }
};
