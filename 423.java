class Solution {
    public String originalDigits(String s) {
        int[] count = new int[10];
        for(char c : s.toCharArray()){
            if(c=='z') count[0]++;
            if(c=='w') count[2]++;
            if(c=='u') count[4]++;
            if(c=='x') count[6]++;
            if(c=='s') count[7]++;
            if(c=='o') count[1]++;
            if(c=='g') count[8]++;
            if(c=='v') count[5]++;
            if(c=='i') count[9]++;
            if(c=='t') count[3]++;
        }
        count[7]-=count[6];
        count[1]-=(count[0]+count[2]+count[4]);
        count[5]-=count[7];
        count[9]-=(count[8]+count[6]+count[5]);
        count[3]-=(count[2]+count[8]);
        String result = "";
        for(int i=0;i<10;i++){
            for(int j=0;j<count[i];j++){
                result+=i;
            }
        }
        return result;
    }
}