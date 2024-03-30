//Author: John Photis
//Purpose: This Java program outputs the rotated matrix. 


package MoreArrays;

import java.util.*;

public class Rotate {
	 
	public static int[][] rotate(int[][] matrix){
	        for (int i = 0; i < matrix.length / 2; i++) {
	            for (int j = i; j < matrix.length - i - 1; j++) {
	                int temp = matrix[i][j];
	                matrix[i][j] = matrix[matrix.length - 1 - j][i];
	                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
	                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
	                matrix[j][matrix.length - 1 - i] = temp;
	            }
	        }
	        return matrix;
	    }

	    public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        
	        System.out.print("Please enter the value of N: ");
	        int N = input.nextInt();
	        int[][] matrix = new int[N][N];
	        for(int i=0; i<N; i++){
	            for(int j=0; j<N; j++){
	                System.out.print("Enter value for row index " + i + " and column index " + j + ": ");
	                matrix[i][j] = input.nextInt();
	            }
	        }

	        System.out.println("Given input matrix= ");
	        for(int i=0; i<N; i++){
	            for(int j=0; j<N; j++){
	                System.out.print( matrix[i][j]+" ");
	            }
	            System.out.println();
	        }
	        System.out.println();
	        matrix = rotate(matrix);
	        System.out.println("rotate the input matrix such that it becomes: ");
	        for(int i=0; i<N; i++){
	            for(int j=0; j<N; j++){
	                System.out.print(matrix[i][j]+" ");
	            }
	            System.out.println();

	        }

	}

}
