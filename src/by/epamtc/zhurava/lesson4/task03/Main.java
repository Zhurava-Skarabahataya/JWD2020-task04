/*
 * 3. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epamtc.zhurava.lesson4.task03;

public class Main {
	public static void main(String[] args) {
		int n = 10;
		int[][] matrix = getMatrix(n);

		printMatrix(matrix);
	}

	private static int[][] getMatrix(int n) {

		int[][] result;
		result = new int[n][n];

		int middle;
		middle = n / 2;

		for (int row = 0; row < middle; row++) {
			for (int col = row; col < n - row; col++) {
				result[row][col] = 1;
			}
		}

		for (int row = middle; row < n; row++) {
			for (int col = n - (row + 1); col < (row + 1); col++) {
				result[row][col] = 1;
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
