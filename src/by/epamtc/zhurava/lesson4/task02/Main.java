/*
 * 2. Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 */

package by.epamtc.zhurava.lesson4.task02;

public class Main {

	public static void main(String[] args) {

		int n;
		int[][] matrix;

		n = 6;
		matrix = getMatrix(n);

		printMatrix(matrix);
	}

	private static int[][] getMatrix(int n) {

		int[][] result;
		result = new int[n][n];

		for (int index = 0; index < result.length; index++) {
			
			int firstMul;
			int secondMul;
			
			firstMul = index + 1;
			secondMul = index + 2;
			
			result[index][index] = firstMul * secondMul;
		}

		return result;
	}

	private static void printMatrix(int[][] matrix) {

		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[row].length; col++) {
				
				System.out.printf("%3d ", matrix[row][col]);
			}

			System.out.println();
		}

	}
}
