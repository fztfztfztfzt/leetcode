#define ULL unsigned long long
class Solution {
public:
    int distinctEchoSubstrings(string text) {
        int n = text.size();
        vector<ULL> h(n+1), power(n+1);
        h[0]=0;power[0]=1;
        for(int i=1;i<=n;i++){
            h[i]=(h[i-1]*base+text[i-1]-'a'+1);
            power[i]=power[i-1]*base;
        }
        unordered_set<ULL> res;
        for(int len=2;len<=n;len+=2){
            for(int s=1;s<=n-len+1;s++){
                ULL s1 = hash(h,power,s,len/2);
                ULL s2 = hash(h,power,s+(len/2),len/2);
                if(len==16){
                    printf("%d %d\n",s,len);
                    printf("%lld, %lld\n",s1,s2);
                }
                if(s1==s2&&res.find(s1)==res.end()){
                    res.insert(s1);
                }
            }
        }
        return res.size();
    }
private:
    const int base = 131;
    const ULL M = 2894379658415799649;
    ULL hash(vector<ULL>& h, vector<ULL>& power, int start, int len){
        return (h[start+len-1]-h[start-1]*power[len]);
    }
};
