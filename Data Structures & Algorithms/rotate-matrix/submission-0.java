class Solution {
    public void swap(int i, int j, int[][] matrix){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int i, int j, int[] arr){
        while(i < j){
            swap(i, j, arr);
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(i > j){
                    swap(i, j, matrix);
                }
            }
        }
        for(int[] row : matrix){
            reverse(0, n-1, row);
        }
    }
}
