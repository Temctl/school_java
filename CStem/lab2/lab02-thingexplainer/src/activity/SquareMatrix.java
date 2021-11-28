package activity;

public class SquareMatrix {
    private int[][] matrix; 
    private int size;

    //TODO: Update Class
    public SquareMatrix(int[][] matrix){
        this.matrix = matrix;
        size = matrix[0].length;
    }

    public SquareMatrix(int n){
        this.matrix = new int[n][n];
        this.size = n;
    }

    //getter
    public int matrixGet(int row, int col){
        return matrix[row][col];
    }

    //setter
    public void matrixSet(int row, int col, int num){
        matrix[row][col] = num;
    }

    //adds another matrix to this one and returns the result matrix
    public SquareMatrix add(SquareMatrix other){
        SquareMatrix newMatrix = new SquareMatrix(size); 
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                int num = matrix[row][col] + other.matrixGet(row, col);
                newMatrix.matrixSet(row, col, num);
            }
        }
        return newMatrix;
    }

    //subtract matrix by the other matrix
    public SquareMatrix subtract(SquareMatrix other){
        SquareMatrix newMatrix = new SquareMatrix(size); 
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                int num = matrix[row][col] - other.matrixGet(row, col);
                newMatrix.matrixSet(row, col, num);
            }
        }
        return newMatrix;
    }

    
    public boolean equals(SquareMatrix obj){
        boolean result = true; 
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(matrix[row][col] != obj.matrixGet(row, col)){
                    result = false;
                }
            }
        }
        return result;
    }

    //checks if the matrix is diogonal
    public boolean isDiagonal(){
        boolean result = true; 
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(row != col && matrix[row][col] != 0){
                    result = false;
                }
            }
        }
    
        return result;
    }

    //checks if the matrix is identity matrix
    public boolean isIdentity(){
        boolean result = true; 
        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                if(row == col){
                    if(matrix[row][col] != 1){
                        result = false;
                    }
                }else{
                    if(matrix[row][col] != 0){
                        result = false;
                    }
                }
            }
        }
    
        return result;
    }

    //multiply matrix by the other matrix
    public SquareMatrix multiply(SquareMatrix other){
        SquareMatrix newMatrix = new SquareMatrix(size); 
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    int num = matrix[i][k] * other.matrixGet(k, j);
                    newMatrix.matrixSet(i, j, num);
                }
            }
        }
        return newMatrix;
    }

    
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("\n");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result.append(matrix[i][j]).append("\t");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
