class Solution {
public:
    bool isMonotonic(vector<int>& A) {
        if(A.size()<2) return true;
        int type = 0;
        for(int i=0;i<A.size()-1;i++){
            if(A[i]<A[i+1]){
                if(type==0) type=1;
                else if(type==2) return false; 
            }else if(A[i]>A[i+1]){
                if(type==0) type=2;
                else if(type==1) return false;
            }
        }
        return true;
    }
};
