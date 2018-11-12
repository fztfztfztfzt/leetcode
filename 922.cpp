class Solution {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        int size = A.size();
        int tmp;
        int i = 0;
        int j = 1;
        for(;;){
            printf("%d %d\n",i,j);
            while(i<size&&((A[i]&1)==0)) i+=2;
            while(j<size&&((A[j]&1)==1)) j+=2;
            if(i<size&&j<size){
                tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }else{
                break;
            }
        }
        return A;
    }
};
