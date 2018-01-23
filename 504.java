class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if(num<0){
            flag = true;
            num = -num;
        }
        int a;
        while(num>=7){
            a = num%7;
            num = num/7;
            sb.append(a);
        }
        sb.append(num);
        if(flag) sb.append("-");
        return sb.reverse().toString();
    }
}