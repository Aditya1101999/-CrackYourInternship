class Solution {
    public void solveSudoku(char[][] board) {
       if(board==null||board.length==0){
           return;
       }
       solve(board);
    }
    private boolean solve(char[][] board){
    for(int i=0;i<board.length;i++){
       for(int j=0;j<board.length;j++){
           if(board[i][j]=='.'){
               for(char c='1';c<='9';c++){
                   if(isSafe(board,i,j,c)){
                       board[i][j]=c;
                       if(solve(board)) return true;
                       board[i][j]='.';
                   }
               }
               return false; // move the statement outside of the loop->after checking all cells
           }
       }
   }
   return true;
}

    public boolean isSafe(char[][] board, int row, int col, char digit) {
        //element not in column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] ==digit) {
                return false;
            }
        }
        //element not in row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == digit) {
                return false;
            }
        }
        //element not in grid
        int sr = (row / 3) * 3;//starting row of grid
        int sc = (col / 3) * 3;//starting col of grid
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] ==digit) {
                    return false;
                }
            }
        }
        return true;
    }
}