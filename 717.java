class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i=0;
        while(i<bits.length-1){
            if(bits[i]==1){
                i=i+2;
            }else{
                i++;
            }
        }
        return i==bits.length-1;
    }
}