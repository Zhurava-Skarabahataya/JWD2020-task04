/*
 * 4. Дан линейный массив  . Получить действительную квадратную матрицу порядка n:
 */

package by.epamtc.zhurava.lesson4.task04;

public class Main {

	public static void main(String[] args) {

		int[] array;
		int[][] matrix;

		array = new int[] { 2, 5, 7, 3, 1, 4, 6 };

		matrix = getMatrixFromArray(array);

		printMatrix(matrix);
	}

	private static int[][] getMatrixFromArray(int[] array) {

		int[][] result;
		result = new int[array.length][array.length];

		for (int row = 0; row < result.length; row++) {
			
			for (int col = 0; col < array.length; col++) {
				
				int grade;
				int number;
				
				grade = row + 1;
				number = (int) Math.pow(array[col], grade);
				
				result[row][col] = number;
			}
		}

		return result;
	}

	private static void printMatrix(int[][] matrix) {

		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[row].length; col++) {
				
				System.out.printf("%6d ", matrix[row][col]);
			}

			System.out.println();
		}

	}

}
