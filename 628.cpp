static auto __ = [](){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    return nullptr;
}();

class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        int b1=-1001,b2=-1001,b3=-1001,bn1=1001,bn2=1001;
        for(auto n : nums){
            if(n>b1){
                b3=b2;
                b2=b1;
                b1=n;
            }else if(n>b2){
                b3=b2;
                b2=n;
            }else if(n>b3){
                b3=n;
            }
            if(n<bn1){
                bn2=bn1;
                bn1=n;
            }else if(n<bn2){
                bn2=n;
            }
        }
        return max(b1*b2*b3,b1*bn1*bn2);
    }
};

