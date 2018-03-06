class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int l12 = len2(p1,p2);
        int l13 = len2(p1,p3);
        if(l12==l13){
            return vertical(p1,p2,p3)&&(len2(p4,p2)==len2(p4,p3))&&vertical(p4,p2,p3)&&((p1[0]!=p4[0])||(p1[1]!=p4[1]));
        }else if(l13==2*l12){
            return vertical(p2,p1,p3)&&vertical(p4,p1,p3)&&(len2(p4,p1)==len2(p4,p3))&&((p2[0]!=p4[0])||(p2[1]!=p4[1]));
        }else if(l12==2*l13){
            return vertical(p3,p1,p2)&&vertical(p4,p1,p2)&&(len2(p4,p1)==len2(p4,p2))&&((p3[0]!=p4[0])||(p3[1]!=p4[1]));
        }else return false;
    }
    private int len2(int[] p1,int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0])+(p1[1]-p2[1])*(p1[1]-p2[1]);
    }
    private boolean vertical(int[] p1,int[] p2,int[] p3){
        return 0==((p1[1]-p2[1])*(p1[1]-p3[1])+(p1[0]-p2[0])*(p1[0]-p3[0]));
    }
}