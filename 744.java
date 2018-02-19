class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = Integer.MAX_VALUE;
        char result = '*';
        for(char c : letters){
            int dis = c-target;
            if(dis==0) continue;
            if(dis<0) dis+=26;
            if(dis<min){
                min = dis;
                result = c;
            }
        }
        return result;
    }
}