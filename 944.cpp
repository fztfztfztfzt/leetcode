class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        int len = A[0].length();
        int res = 0;
        for(int j=0;j<len;j++){
            bool flag = true;
            char pre = A[0][j];
            for(int i=1;i<A.size();i++){
                if(A[i][j]<pre){
                    flag = false;
                    break;
                }
                pre = A[i][j];
            }
            if(!flag){
                res++;
            }
        }
        return res;
    }
};
