import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeakColumns {

    static void printPeakColumn(int[][] matrix) {
        /**
         * 1. Try catch block to counter for invalid input or compputational error
         * 2. For loop that goes through each row in the matrix
         * 3. Declare maximum value in each row
         * 4. Another for loop for finding if there are many values in the same row
         * 5. Loop through the values found 
         * 6. Checks through each column to find out if the minimum value is found
         * 7. The prints the values and indices
         *  
         */
        try {
            for (int i = 0; i < matrix.length; i++) {
                int maxInRow = Integer.MIN_VALUE;
                List<Integer> indicesMaxRow = new ArrayList<>();
        
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] > maxInRow) {
                        maxInRow = matrix[i][j];
                    }
                }
                
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == maxInRow) {
                        indicesMaxRow.add(j);
                    }
    
                }
    
        
               for(int value :indicesMaxRow){
    
                boolean isMinInColumn = true;
                for (int[] matrix2 : matrix) {
                    if (matrix2[value] < maxInRow) {
                        isMinInColumn = false;
                        break;
                    }
                }
                if (isMinInColumn) {
                System.out.println("(" +( i+1) + ","+ (value +1) + ")" +" = "+maxInRow );
                 }
               }
        
              
            }
            
        } catch (Exception e) {
            System.out.println("Something wrong while finding the peak value");
        }
        
    }
    
    public static void main(String[] args) {
        // int[][] arr = {{3, 5, 6, 7, 7 },{ 4, 2, 2, 8, 9 },{6, 3, 2, 9, 7 }};
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Please enter the number of columns:");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Please enter the values for the matrix:");
        //Looping through the number of row and columns to store the values
        try {
            for (int[] matrix1 : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix1[j] = sc.nextInt();
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter an integer value");
        }
        sc.close();

        
        printPeakColumn(matrix);
    }
}
