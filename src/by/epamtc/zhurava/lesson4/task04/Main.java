/*
 * 4. Дан линейный массив  . Получить действительную квадратную матрицу порядка n:
 */

package by.epamtc.zhurava.lesson4.task04;

public class Main {

	public static void main(String[] args) {

		int[] array = new int[] { 2, 5, 7, 3, 1, 4, 6 };

		int[][] matrix = getMatrixFromArray(array);

		printMatrix(matrix);
	}

	private static int[][] getMatrixFromArray(int[] array) {
		
		int[][] result;
		result = new int[array.length][array.length];

		for (int row = 0; row < result.length; row++) {
			for (int col = 0; col < array.length; col++) {
				result[row][col] = (int) Math.pow(array[col], row + 1);
			}
		}

		return result;
	}

	private static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%6d ", matrix[i][j]);
			}

			System.out.println();
		}

	}

}
