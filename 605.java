class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeros = 0;
        int num = 0;
        boolean first = true;
        for(int i=0;i<flowerbed.length;i++){
            if(flowerbed[i]==0) zeros++;
            if(flowerbed[i]==1&&first){
                num+=(zeros/2);
                if(num>=n) return true;
                zeros = 0;
                first = false;
            }
            if(flowerbed[i]==1){
                num+=(zeros-1)/2;
                if(num>=n) return true;
                zeros=0;
            }else if(i==flowerbed.length-1){
                if(!first){
                    num+=(zeros/2);
                    if(num>=n) return true;
                    zeros = 0;
                }else{
                    num+=(zeros+1)/2;
                    if(num>=n) return true;
                    zeros=0;
                }
            }
        }
        return false;
    }
}