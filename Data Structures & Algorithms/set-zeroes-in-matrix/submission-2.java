class Solution {
    public void markMatrix(int r, int c, int row, int col, boolean[][] mark){
        for(int j=0 ; j<c ; j++){
            mark[row][j] = true;
        }
        for(int i=0 ; i<r ; i++){
            mark[i][col] = true;
        }
    }
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


        // int r = matrix.length;
        // int c = matrix[0].length;
        // boolean[][] mark = new boolean[r][c];
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         if(matrix[i][j] == 0){
        //             markMatrix(r, c, i, j, mark);
        //         }
        //     }
        // }
        // for(int i=0 ; i<r ; i++){
        //     for(int j=0 ; j<c ; j++){
        //         if(mark[i][j]){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
    }
}
