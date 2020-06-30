/*
1. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epamtc.zhurava.lesson4.task01;

public class Main {

	public static void main(String[] args) {

		int n = 6;

		int[][] matrix = getMatrix(n);

		printMatrix(matrix);
	}

	private static int[][] getMatrix(int n) {

		int[][] result = new int[n][n];

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

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}

			System.out.println();
		}

	}
}
