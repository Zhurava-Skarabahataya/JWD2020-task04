/*
 * 
6. Магическим квадратом порядка n называется квадратная матрица размера nxn, 
составленная из чисел 1, 2, 3, ...,  так, что суммы по каждому столбцу, 
каждой строке и каждой из двух больших диагоналей равны между собой. 
Построить такой квадрат. Пример магического квадрата порядка 3:

 */

package by.epamtc.zhurava.lesson4.task06;

public class Main {

	public static void main(String[] args) {

		int n;
		int[][] magicSquare;

		n = 9;

		magicSquare = getMagicSquare(n);

		printMatrix(magicSquare);
	}

	private static int[][] getMagicSquare(int n) {

		int[][] resultSquare;

		resultSquare = new int[n][n];

		int row;
		row = n / 2;
		int col;
		col = n - 1;

		int number;
		number = 1;
		
		while (number <= n * n) {
			if (row == -1 && col == n) {
				row = 0;
				col = n - 2;
			} else {
				if (col == n) {
					col = 0;
				}
				if (row < 0) {
					row = n - 1;
				}
			}
			if (resultSquare[row][col] != 0) {
				col -= 2;
				row++;
			} else {
				resultSquare[row][col] = number++;
				col++;
				row--;
			}
		}
		return resultSquare;
	}

	private static void printMatrix(int[][] matrix) {

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}

			System.out.println();
		}

	}

}
