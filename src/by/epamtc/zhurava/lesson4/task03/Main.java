/*
 * 3. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epamtc.zhurava.lesson4.task03;

public class Main {

	public static void main(String[] args) {

		int n;
		int[][] matrix;

		n = 10;
		matrix = getMatrix(n);

		printMatrix(matrix);
	}

	private static int[][] getMatrix(int n) {

		int resultLength;
		int[][] result;
		int middle;

		resultLength = n;
		result = new int[resultLength][resultLength];

		middle = n / 2;

		for (int row = 0; row < middle; row++) {

			int lastButOneCol;
			lastButOneCol = n - row;

			for (int col = row; col < lastButOneCol; col++) {

				result[row][col] = 1;
			}
		}

		for (int row = middle; row < resultLength; row++) {
			
			int endCol;
			int startCol;
			
			endCol = row + 1;
			startCol = resultLength - endCol;
			
			for (int col = startCol; col < endCol; col++) {
				
				result[row][col] = 1;
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
