class Solution {
public:
    int longestMountain(vector<int>& A) {
        int res = 0;
        int i = 0;
        int n = A.size();
        while(i<n-1){
            int up = 0,down = 0;
            while(i<n-1&&A[i]<A[i+1]){up++;i++;}
            while(i<n-1&&A[i]>A[i+1]){down++;i++;}
            while(i<n-1&&A[i]==A[i+1]){i++;}
            if(up>0&&down>0) res = max(res,down+up+1);
        }
        return res;
    }
};
