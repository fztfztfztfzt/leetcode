class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        int mask = 15<<28;
        StringBuilder sb = new StringBuilder();
        char[] result = new char[8];
        int temp;
        for(int i=0;i<8;i++){
            temp = (mask&num)>>>((7-i)*4);
            mask = mask>>>4;
            //System.out.println(temp);
            switch(temp){
                case 1: case 2: case 3: case 4: case 5:
                case 6: case 7: case 8: case 9: case 0:
                    result[i] = (char)(temp+48);
                    break;
                case 10:result[i] = 'a';break;
                case 11:result[i] = 'b';break;
                case 12:result[i] = 'c';break;
                case 13:result[i] = 'd';break;
                case 14:result[i] = 'e';break;
                case 15:result[i] = 'f';break;
            }
        }
        temp = 0;
        while(result[temp]=='0') temp++;
        for(int i=temp;i<8;i++) sb.append(result[i]);
        return sb.toString();
    }
}