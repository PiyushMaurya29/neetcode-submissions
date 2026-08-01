class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;

        int currRow = 0;
        int currCol = c-1;
        while(currRow<r && currCol>=0){
            int num = matrix[currRow][currCol];
            if(num == target){
                return true;
            }
            else if(num > target){
                currCol--;
            }
            else currRow++;
        }
        return false;
    }
}
