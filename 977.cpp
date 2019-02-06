class Solution {
public:
    vector<int> sortedSquares(vector<int>& A) {
        vector<int> res;
        int start = 0;
        for(int i=0;i<A.size();i++){
            if(A[i]>=0){
                start=i;
                break;
            }
        }
        int left = start-1;
        int right = start;
        while(left>=0&&right<A.size()){
            int tmp = A[left]+A[right];
            if(tmp>0){
                res.push_back(A[left]*A[left]);
                left--;
            }else if(tmp==0){
                res.push_back(A[left]*A[left]);
                res.push_back(A[right]*A[right]);
                left--;
                right++;
            }else{
                res.push_back(A[right]*A[right]);
                right++;
            }
        }
        while(left>=0){res.push_back(A[left]*A[left]);left--;}
        while(right<A.size()){res.push_back(A[right]*A[right]);right++;}
        return res;
    }
};
