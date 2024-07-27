package Matrix;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> a=new ArrayList<>();
        int startRow=0;
        int startColumn=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        while(startRow<=endRow && startColumn<=endCol){
            //top
            for(int j=startColumn;j<=endCol;j++){
                a.add(matrix[startRow][j]);
            }
            //right
            for(int i=startRow+1;i<=endRow;i++){
                a.add(matrix[i][endCol]);
            }
            //bottom
            for(int j=endCol-1;j>=startColumn;j--){
                //for odd cases to avoid duplicate values printing
                if(startRow==endRow){
                    break;
                }
                a.add(matrix[endRow][j]);
            }
            //left
            for(int i=endRow-1;i>=startRow+1;i--){
                //for odd cases to avoid duplicate values printing
                if(startColumn==endCol){
                    break;
                }
                a.add(matrix[i][startColumn]);
            }
            startColumn++;
            startRow++;
            endRow--;
            endCol--;
    }
        return a;
}
}