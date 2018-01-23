class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int bot = 0;
        int top = 0;
        for(char a : s.toCharArray()){
            if(a=='}'||a==']'||a==')'){
                if(bot==top) return false;
                if((stack[top-1]==a-1)||(stack[top-1]==a-2)) top--;
                else return false;
            }else{
                stack[top++] = a;
            }
        }
        return top==bot;
    }
}