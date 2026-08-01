class Solution {
    public boolean checkRowAndColumn(int index, char[][] board){
        Set<Character> rowSet = new HashSet<>();
        Set<Character> columnSet = new HashSet<>();
        for(int k=0 ; k<9 ; k++){
            if(board[index][k] != '.'){
                if(rowSet.contains(board[index][k])) return false;
                rowSet.add(board[index][k]);
            }
            if(board[k][index] != '.'){
                if(columnSet.contains(board[k][index])) return false;
                columnSet.add(board[k][index]);
            }
        }
        return true;
    }
    public boolean checkSquare(int i, int j, char[][] board){
        Set<Character> set = new HashSet<>();
        for(int row=i ; row<i+3 ; row++){
            for(int col=j ; col<j+3 ; col++){
                if(board[row][col] != '.'){
                    if(set.contains(board[row][col])) return false;
                    set.add(board[row][col]);
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int index=0 ; index<9 ; index++){
            if(!checkRowAndColumn(index, board)) return false;
        }
        for(int i=0 ; i<9 ; i+=3){
            for(int j=0 ; j<9 ; j+=3){
                if(!checkSquare(i, j, board)){
                    return false;
                }
            }
        }
        return true;
    }
}
