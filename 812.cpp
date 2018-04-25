class Solution {
public:
    double largestTriangleArea(vector<vector<int>>& points) {
        int n = points.size();
        double res = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    double temp = TriangleArea(points[i],points[j],points[k]);
                    if(temp>res) res=temp;
                }
            }
        }
        return res;
    }
private:
    double TriangleArea(vector<int>& a, vector<int>& b, vector<int>& c){
        return 0.5*abs(a[0]*b[1]+b[0]*c[1]+c[0]*a[1]-b[0]*a[1]-c[0]*b[1]-a[0]*c[1]);
    }
};