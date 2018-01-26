class Solution {
    public int magicalString(int n) {
        if(n==0) return 0;
        if(n<=3) return 1;
        int[] data = new int[n+1];
        data[0]=1;data[1]=2;data[2]=2;
        int ones = 1;
        int a = 3;
        int b = 2;
        int turn = 1;
        while(a<n){
            for(int i=0;i<data[b];i++){
                data[a] = turn;
                if(turn==1&&a<n) ones++;
                a++;
            }
            turn = turn^3;
            b++;
        }
        return ones;
    }
}