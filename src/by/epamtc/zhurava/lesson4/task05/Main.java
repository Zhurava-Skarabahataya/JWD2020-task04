/*
 5. Найдите произведение двух матриц.
 */

package by.epamtc.zhurava.lesson4.task05;

public class Main {

	public static void main(String[] args) {

		int[][] firstMatrix;
		int[][] secondMatrix;

		firstMatrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 3, 2, 1 } };
		secondMatrix = new int[][] { { 1, 2 }, { 4, 3 }, { 1, 6 } };

		int[][] result;
		result = multiplyMatrix(firstMatrix, secondMatrix);

		if (result != null) {
			printMatrix(result);
			
		} else {
			System.out.println("Умножение невозможно");
		}

	}

	private static int[][] multiplyMatrix(int[][] firstMatrix, int[][] secondMatrix) {

		if (firstMatrix[0].length != secondMatrix.length) {
			return null;
		}

		int newMatrixRows;
		int newMatrixCols;
		int[][] result;

		newMatrixRows = firstMatrix.length;
		newMatrixCols = secondMatrix[0].length;
		
		result = new int[newMatrixRows][newMatrixCols];

		for (int i = 0; i < result.length; i++) {
			
			for (int j = 0; j < result.length; j++) {
				
				for (int k = 0; k < result[0].length; k++) {
					
					result[i][k] += firstMatrix[i][j] * secondMatrix[j][k];
				}
			}
		}

		return result;
	}

	private static void printMatrix(int[][] matrix) {

		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[row].length; col++) {
				
				System.out.print(matrix[row][col] + " ");
			}

			System.out.println();
		}

	}

}
