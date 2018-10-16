// The rand7() API is already defined for you.
// int rand7();
// @return a random integer in the range 1 to 7

class Solution {
public:
    int rand10() {
        return rand40()%10+1;
    }
private:
    int rand49(){
        return 7*(rand7()-1)+rand7()-1;
    }
    int rand40(){
        int tmp = rand49();
        while(tmp>=40) tmp = rand49();
        return tmp;
    }
};
