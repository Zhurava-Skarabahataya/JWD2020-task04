/*
 * 2. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epamtc.zhurava.lesson4.task02;

public class Main {

	public static void main(String[] args) {

		int n = 6;

		int[][] matrix = getMatrix(n);

		printMatrix(matrix);
	}

	private static int[][] getMatrix(int n) {

		int[][] result = new int[n][n];

		for (int i = 0; i < result.length; i++) {
			result[i][i] = (i + 1) * (i + 2);
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
