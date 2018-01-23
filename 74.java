class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        if(matrix[0].length==0) return false;
        
		int startrow = 0;
		int endrow = matrix.length - 1;
		int row = -1;
		int col = matrix[0].length - 1;

		while (startrow + 1 < endrow) {
			int mid = startrow + (endrow - startrow) / 2;
			if (matrix[mid][col] < target) {
				startrow = mid;
			} else {
				endrow = mid;
			}
		}

		if (matrix[startrow][col] >= target) {
			row = startrow;
		} else if (matrix[endrow][col] >= target) {
			row = endrow;
		} else
			return false;
        int line = row;
        int low = 0;
        int high = matrix[line].length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[line][mid]<target) low = mid+1;
            else if(matrix[line][mid]>target) high = mid-1;
            else return true;
        }
        return false;
    }
}