class Solution {
public:
    int fib(int N) {
        if(N==0) return 0;
        if(N<=2) return 1;
        int a = 1;
        int b = 1;
        while(N>2){
            int tmp = a+b;
            a = b;
            b = tmp;
            N--;
        }
        return b;
    }
};