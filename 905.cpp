class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        int left = 0;
        int right = A.size()-1;
        while(left<right){
            while(left<right&&(A[left]&1)==0) left++;
            while(left<right&&(A[right]&1)==1) right--;
            if(left<right){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
            }
        }
        return A;
    }
};
