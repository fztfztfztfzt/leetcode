class Solution {
    public boolean validUtf8(int[] data) {
        int status;
        int n=0;
        while(n<data.length){
            //System.out.println(data[n]);
            status = checkHead(data[n++]);
            if(status==-1) return false;
            if(status==0) continue;
            else if(status==1){
                //System.out.println("status1");
                if(n==data.length) return false;
                status = checkHead(data[n++]);
                if(status!=-1) return false;
            }else if(status==2){
                //System.out.println("status2");
                if(n==data.length) return false;
                status = checkHead(data[n++]);
                if(status!=-1) return false;
                if(n==data.length) return false;
                status = checkHead(data[n++]);
                if(status!=-1) return false;
            }else if(status==3){
                //System.out.println("status3");
                if(n==data.length) return false;
                status = checkHead(data[n++]);
                if(status!=-1) return false;
                if(n==data.length) return false;
                status = checkHead(data[n++]);
                if(status!=-1) return false;
                if(n==data.length) return false;
                status = checkHead(data[n++]);
                if(status!=-1) return false;
            }else return false;
        }
        return true;
    }
    private int checkHead(int data){
        if((data&0b10000000)==0b00000000) return 0;
        if((data&0b11000000)==0b10000000) return -1;
        if((data&0b11100000)==0b11000000) return 1;
        if((data&0b11110000)==0b11100000) return 2;
        if((data&0b11111000)==0b11110000) return 3;
        return 4;
    }
}