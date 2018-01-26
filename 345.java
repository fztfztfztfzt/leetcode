class Solution {
    public String reverseVowels(String s) {
        char[] temp = s.toCharArray();
        int start = 0;
        int end = temp.length-1;
        while(start<end){
            //System.out.println(start);
            while(start<end&&!isVowels(temp[start])) start++;
            while(start<end&&!isVowels(temp[end])) end--;
            if(start<end){
                char t = temp[start];
                temp[start] = temp[end];
                temp[end] = t;
                start++;end--;
            }
        }
        return new String(temp);
    }
    private boolean isVowels(char c){
        if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U'||c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return true;
        return false;
    }
}