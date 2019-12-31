class Solution {
public:
    int candy(vector<int>& ratings) {
        int cnt = 0;
        int res = 1;
        int pre = 1;
        for(int i=1;i<ratings.size();++i){
            if(ratings[i]>=ratings[i-1]){
                if(cnt>0){
                    res += cnt*(cnt+1)/2;
                    if(cnt>=pre) res += cnt-pre+1;
                    cnt = 0;
                    pre = 1;
                }
                pre = (ratings[i]==ratings[i-1])?1:pre+1;
                res += pre;
            }else{
                ++cnt;
            }
        }
        if(cnt>0){
            res += cnt*(cnt+1)/2;
            if(cnt>=pre) res += cnt-pre+1;
        }
        return res;
    }
};