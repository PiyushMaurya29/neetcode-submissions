class Solution {
    public boolean binarySearch(int[] arr, int target){
        int left=0, right=arr.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(arr[mid] == target){
                return true;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        // int r = matrix.length;
        // int c = matrix[0].length;
        // int currRow = 0;
        // int currCol = c-1;
        // while(currRow<r && currCol>=0){
        //     int num = matrix[currRow][currCol];
        //     if(num == target){
        //         return true;
        //     }
        //     else if(num > target){
        //         currCol--;
        //     }
        //     else currRow++;
        // }
        // return false;

        for(int[] row : matrix){
            if(binarySearch(row, target)){
                return true;
            }
        }
        return false;
    }
}
