class Solution {
    public String decodeString(String s) {
        int curNum = 0;
        String curChr = "";
        Stack<Integer> num = new Stack<>();
        Stack<String> chr = new Stack<>();
        for(char c : s.toCharArray()){
            if(c>='0'&&c<='9'){
                curNum=curNum*10+(c-'0');
            }else if(c=='['){
                num.push(curNum);
                curNum = 0;
                chr.push(curChr);
                curChr = "";
            }else if(c==']'){
                curNum = num.pop();
                String temp = "";
                for(;curNum>0;curNum--){
                    temp+=curChr;
                }
                curChr = chr.pop()+temp;
            }else{
                curChr += c;
            }
        }
        return curChr;
    }
}