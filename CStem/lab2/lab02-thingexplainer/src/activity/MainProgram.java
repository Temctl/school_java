package activity;
import activity.SquareMatrix;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MainProgram {

    public static SquareMatrix read(String location) throws IOException {
        File file      = new File(location);
        Scanner input  = new Scanner(file);
        int size       = input.nextInt();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
        input.close();
        return new SquareMatrix(matrix);
    }

    public static void write(String location, StringBuilder builder) throws IOException {
        File file           = new File(location);
        PrintWriter writer  = new PrintWriter(file);

        writer.println(builder);
        writer.close();
    }

    private static int[][] createMatrix(String location) throws FileNotFoundException{
        File matrixFile = new File(location); 
        Scanner input = new Scanner(matrixFile);

        int size = Integer.parseInt(input.next());//gets the first token which is the size
        int[][] matrix = new int[size][size];

        while(input.hasNext()){
            for(int row = 0; row < size; row++){
                for(int col = 0; col < 3; col++){
                    matrix[row][col] = Integer.parseInt(input.next());
                }
            }
        }
        input.close();
        return matrix;
    }

    public static void main(String[] args) throws IOException {
        String location       = "data" + File.separator + "matrix.txt";
        String otherLocation  = "data" + File.separator + "other_matrix.txt";
        String outputLocation = "data" + File.separator + "output.txt";

        // Create object to append string output of matrix
        StringBuilder builder = new StringBuilder("\n");

        // TODO : Create matrices for testing
        
        int[][] matrix = createMatrix(location);
        int[][] otherMatrix = createMatrix(otherLocation);


        SquareMatrix testMatrix = new SquareMatrix(matrix);
        SquareMatrix testMatrix2 = new SquareMatrix(otherMatrix);

        // TODO : Test operations of Square Matrices
        System.out.println("multiplied: \n" + testMatrix.multiply(testMatrix2));
        builder.append("multiplied: \n" + testMatrix.multiply(testMatrix2));//add it to te output file

        System.out.println("added: \n" + testMatrix.add(testMatrix2));
        builder.append("added: \n" + testMatrix.add(testMatrix2));

        System.out.println("sibtracted: \n" + testMatrix.subtract(testMatrix2));
        builder.append("sibtracted: \n" + testMatrix.subtract(testMatrix2));

        if (testMatrix.equals(testMatrix2)){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
        // write to output file
        write(outputLocation, builder);

    }
} 
