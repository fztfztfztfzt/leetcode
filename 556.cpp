class Solution {
public:
    int nextGreaterElement(int n) {
        int digits[32];
        int len = 0;
        while(n>0){
            digits[len++] = n%10;
            n = n/10;
        }
        int first = -1;
        for(int i=0;i<len-1;i++){
            if(digits[i]>digits[i+1]){
                first = i+1;
                break;
            }
        }
        if(first==-1) return -1;
        int second = 0;
        for(int i=0;i<first;i++){
            if(digits[i]>digits[first]){
                second = i;
                break;
            }
        }
        int tmp = digits[first];
        digits[first] = digits[second];
        digits[second] = tmp;
        //printf("%d %d\n",first,second);
        reverse(digits,first);
        long long res = 0;
        long long mul = 1;
        for(int i=0;i<len;i++){
            res += mul*digits[i];
            if(res>INT_MAX) return -1;
            mul*=10;
        }
        return res;
    }
private:
    void reverse(int* a, int len){
        for(int i=0;i<len/2;i++){
            int tmp = a[i];
            a[i] = a[len-1-i];
            a[len-1-i] = tmp;
        }
    }
};
