class Solution {
    public int calculate(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char sign = '+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(((c-'0')>=0)&&((c-'0')<=9)){
                num = num*10+(c-'0');
            }
            if((c=='-'||c=='+'||c=='*'||c=='/')||i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign=='-'){
                    stack.push(-num);
                }else if(sign=='*'){
                    stack.push(stack.pop()*num);
                }else if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                num=0;
                sign = c;
            }
        }
        int re = 0;
        while(!stack.isEmpty()){
            re+=stack.pop();
        }
        return re;
    }
}