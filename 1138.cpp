class Solution {
public:
    string alphabetBoardPath(string target) {
        int y=0,x=0;
        string res = "";
        for(char c : target){
            pair<int,int> next = getXY(c);
            int dy = next.first-y;
            int dx = next.second-x;
            if(dy<0) for(int i=0;i<abs(dy);i++) res+='U';
            if(dx<0) for(int i=0;i<abs(dx);i++) res+='L';
            if(dx>0) for(int i=0;i<abs(dx);i++) res+='R';
            if(dy>0) for(int i=0;i<abs(dy);i++) res+='D';
            res += '!';
            x = next.second;
            y = next.first;
        }
        return res;
    }
private:
    pair<int,int> getXY(char c){
        int a = c-'a';
        return make_pair(a/5,a%5);
    }
};
