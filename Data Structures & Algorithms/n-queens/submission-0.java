class Solution {
    List<List<String>> result;
    public List<String> getList(char[][] matrix){
        List<String> list = new ArrayList<>();
        for(int i=0 ; i<matrix.length ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0 ; j<matrix[0].length ; j++){
                sb.append(matrix[i][j]);
            }
            list.add(sb.toString());
        }
        return list;
    }
    public boolean isPossibleToPlace(int row, int col, char[][] matrix){
        for(int i=0 ; i<row ; i++){
            if(matrix[i][col]=='Q') return false;
        }
        for(int j=0 ; j<col ; j++){
            if(matrix[row][j]=='Q') return false;
        }

        // Upper LeftDiagonal
        int r=row, c=col;
        while(r>=0 && c>=0){
            if(matrix[r][c]=='Q') return false;
            r--;
            c--;
        }
        // Upper RightDiagonal
        while(row>=0 && col<matrix[0].length){
            if(matrix[row][col]=='Q') return false;
            row--;
            col++;
        }
        return true;
    }
    public void solve(int currRow, char[][] matrix){
        if(currRow >= matrix.length){
            result.add(getList(matrix));
            return;
        }
        for(int j=0 ; j<matrix[0].length ; j++){
            if(isPossibleToPlace(currRow, j, matrix)){
                matrix[currRow][j] = 'Q';
                solve(currRow+1, matrix);
                matrix[currRow][j] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {      
        result = new ArrayList<>();
        char[][] matrix = new char[n][n];
        for(char[] row : matrix){
            Arrays.fill(row, '.');
        }
        solve(0, matrix);
        return result;
    }
}
