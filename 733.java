class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(newColor!=image[sr][sc]) floodFill(image,sr,sc,newColor,image[sr][sc]);
        return image;
    }
    private void floodFill(int[][] image,int sr,int sc,int newColor,int color){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length) return;
        if(color!=image[sr][sc]) return;
        image[sr][sc]=newColor;
        floodFill(image,sr-1,sc,newColor,color);
        floodFill(image,sr,sc-1,newColor,color);
        floodFill(image,sr+1,sc,newColor,color);
        floodFill(image,sr,sc+1,newColor,color);
    }
}