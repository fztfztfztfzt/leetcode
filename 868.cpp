class Solution {
public:
    int binaryGap(int N) {
        int pre = -1;
        int res = 0;
        int pos = 0;
        while(N!=0){
            int b = (N&1);
            if(b==1){
                if(pre==-1) pre = pos;
                else{
                    res = max(pos-pre,res);
                    pre = pos;
                }
            }
            N>>=1;
            pos++;
        }
        return res;
    }
};
