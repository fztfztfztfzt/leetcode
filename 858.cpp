class Solution {
public:
    int mirrorReflection(int p, int q) {
        //kq = np
        int temp = GCD(p,q);
        int k = p/temp;
        int n = q/temp;
        //printf("%d %d\n",k,n);
        if(((n&1)==0)&&((k&1)==1)) return 0;
        if(((n&1)==1)&&((k&1)==1)) return 1;
        if(((n&1)==1)&&((k&1)==0)) return 2;
        return -1;
    }
private:
    int GCD(int a, int b){
        int max,min;
        if(a>b){
            max = a;
            min = b;
        }else{
            max = b;
            min = a;
        }
        int temp = min;
        while(max%min != 0){
		    temp = max%min;
		    max = min;
		    min = temp;
	    }
        return temp;
    }
};
