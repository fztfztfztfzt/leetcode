class Solution {
public:
    bool isRobotBounded(string instructions) {
        int X = 0;
        int Y = 0;
        int turn = 0;
        for(int i=0;i<4;i++){
            for(char c : instructions){
                if(c=='G'){
                    if(turn==0) Y++;
                    else if(turn==1) X++;
                    else if(turn==2) Y--;
                    else X--;
                }else if(c=='L'){
                    turn = (turn+3)%4;
                }else{
                    turn = (turn+1)%4;
                }
            }
        }
        return (X==0)&&(Y==0);
    }
};
