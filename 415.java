class Solution {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        StringBuilder sb = new StringBuilder();
        int n1 = c1.length-1;
        int n2 = c2.length-1;
        int c = 0;
        int a;
        while(n1>=0&&n2>=0){
            a = (c1[n1]-'0')+(c2[n2]-'0')+c;
            c = a/10;
            a = a%10;
            sb.insert(0,a);
            n1--;n2--;
        }
        while(n1>=0){
            a = (c1[n1]-'0')+c;
            c = a/10;
            a = a%10;
            sb.insert(0,a);
            n1--;
        }
        while(n2>=0){
            a = (c2[n2]-'0')+c;
            c = a/10;
            a = a%10;
            sb.insert(0,a);
            n2--;
        }
        if(c!=0) sb.insert(0,1);
        return sb.toString();
    }
}