class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        boolean[] rowHasZero = new boolean[r];
        boolean[] columnHasZero = new boolean[c];

        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(matrix[i][j] == 0){
                    rowHasZero[i] = true;
                    columnHasZero[j] = true;
                }
            }
        }

        for(int i=0 ; i<r ; i++){
            for(int j=0 ; j<c ; j++){
                if(rowHasZero[i] || columnHasZero[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
