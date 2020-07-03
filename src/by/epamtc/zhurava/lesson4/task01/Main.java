/*
1. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epamtc.zhurava.lesson4.task01;

public class Main {

	public static void main(String[] args) {

		int n = 6;
		int[][] matrix;
		
		matrix = getMatrix(n);

		printMatrix(matrix);
	}

	private static int[][] getMatrix(int n) {

		int[][] result;
		result = new int[n][n];

		for (int row = 0; row < n; row++) {

			if (row % 2 == 0) {

				int counter = 1;
				
				for (int column = 0; column < n; column++) {
					
					result[row][column] = counter++;
				}

			} else {

				int counter = n;
				
				for (int column = 0; column < n; column++) {
					
					result[row][column] = counter--;
				}
			}
		}

		return result;
	}

	private static void printMatrix(int[][] matrix) {

		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[row].length; col++) {
				
				System.out.printf("%2d ", matrix[row][col]);
			}

			System.out.println();
		}

	}
}
