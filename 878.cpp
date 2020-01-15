class Solution {
public:
    int nthMagicalNumber(int N, int A, int B) {
        long lcm = A*B/gcd(A,B), left=0, right=1e14;
        while(left<right){
            long mid = (right-left)/2+left;
            if(mid/A+mid/B-mid/lcm<N) left=mid+1;
            else right=mid;
        }
        return left%(1000000007);
    }
private:
    int gcd(int a, int b){
        return (b==0)?a:gcd(b,a%b);
    }
};

class Solution {
public:
    int nthMagicalNumber(int N, int A, int B) {
        long lcm = A*B/gcd(A,B), M = 1000000007;
        long len = lcm/A+lcm/B-1, cnt = N/len, rem = N%len;
        double nearest = rem/(1.0/A+1.0/B);
        int plus = min(ceil(nearest/A)*A,ceil(nearest/B)*B);
        return (lcm*cnt+plus)%M;
    }
private:
    int gcd(int a, int b){
        return (b==0)?a:gcd(b,a%b);
    }
};
