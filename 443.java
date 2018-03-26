class Solution {
    public int compress(char[] chars) {
        char cur = chars[0];
        int curc = 1;
        int pos = 1;
        int real = 0;
        while(pos<chars.length){
            char c = chars[pos];
            if(c==cur){
                curc++;
            }else{
                chars[real++]=cur;
                if(curc!=1){
                    if(curc>=1000){
                        chars[real++] = (char)('0'+curc/1000);
                        curc%=1000;
                    }
                    if(curc>=100){
                        chars[real++] = (char)('0'+curc/100);
                        curc%=100;
                    }
                    if(curc>=10){
                        chars[real++] = (char)('0'+curc/10);
                        curc%=10;
                    }
                    chars[real++] = (char)('0'+curc);
                }
                cur = c;
                curc=1;
            }
            pos++;
        }
        chars[real++]=cur;
        if(curc!=1){
            if(curc>=1000){
                chars[real++] = (char)('0'+curc/1000);
                curc%=1000;
            }
            if(curc>=100){
                chars[real++] = (char)('0'+curc/100);
                curc%=100;
            }
            if(curc>=10){
                chars[real++] = (char)('0'+curc/10);
                curc%=10;
            }
            chars[real++] = (char)('0'+curc);
        }
        return real;
    }
}