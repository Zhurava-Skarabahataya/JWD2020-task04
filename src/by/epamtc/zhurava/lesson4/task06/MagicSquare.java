package by.epamtc.zhurava.lesson4.task06;

public class MagicSquare {

	public static void main(String[] args) {
		int n = 8;
		int[][] magicSquare = null;

		if (n % 2 == 1) {
			magicSquare = generateOddMagicSquare(n);
		} else if (n % 4 != 0) {
			magicSquare = generateOneEvenMagicSquare(n);
		} else {
			magicSquare = generateTwoEvenSquare(n);
		}
		printMatrix(magicSquare);

	}

	private static int[][] generateTwoEvenSquare(int n) {
		int[][] resultSquare = new int[n][n];
		resultSquare = generateAscendingMatrix(n);
		int reverceCounter = n * n;

		int half = n / 2;
		int quater = n / 4;
		int threeQuaters = quater + half;
		for (int row = 0; row < n; row++) {
			if (row < quater || row >= (quater * 3)) {
				for (int col = quater; col < threeQuaters; col++) {
					resultSquare[row][col] = 0;
				}
			} else {
				for (int col = 0; col < quater; col++) {
					resultSquare[row][col] = 0;
				}

				for (int col = threeQuaters; col < n; col++) {
					resultSquare[row][col] = 0;

				}
			}
		}

		for (int rows = 0; rows < n; rows++) {
			for (int cols = 0; cols < n; cols++) {
				if (resultSquare[rows][cols] == 0) {
					if (isSquareContainsNumber(resultSquare, reverceCounter)) {
						reverceCounter--;
						cols--;
					} else {
						resultSquare[rows][cols] = reverceCounter--;

					}
				}

			}
		}

		return resultSquare;
	}

	private static boolean isSquareContainsNumber(int[][] square, int reverceCounter) {
		int n;
		n = square.length;

		for (int rows = 0; rows < n; rows++) {
			for (int cols = 0; cols < n; cols++) {
				if (square[rows][cols] == reverceCounter) {
					return true;
				}
			}
		}
		return false;
	}

	private static int[][] generateOneEvenMagicSquare(int n) {
		int[][] resultSquare;
		resultSquare = new int[n][n];
		int middle = n / 2;

		int[][] subQuadrant = generateOddMagicSquare(n / 2);

		int[] subQuadrantNumbers = { 0, 2, 3, 1 };

		for (int row = 0; row < resultSquare.length; row++) {
			for (int col = 0; col < resultSquare.length; col++) {
				int quadrantNumber = findQuadrantNumber(row, col, middle);
				resultSquare[row][col] = subQuadrant[row % middle][col % middle] + (middle * middle) * quadrantNumber;

			}
		}

		switchRows(resultSquare, n);

		int subSquareMiddle = middle / 2;
		for (int row = 0; row < middle; row++) {
			int rowToSwitch = row + middle;
			int startPointAtRow;
			if (row != subSquareMiddle) {
				startPointAtRow = 0;
			} else {
				startPointAtRow = 1;
			}
			for (int col = startPointAtRow; col < subSquareMiddle; col++) {
				int temporary = resultSquare[row][col];
				resultSquare[row][col] = resultSquare[rowToSwitch][col];
				resultSquare[rowToSwitch][col] = temporary;
				System.out.println(temporary + " " + resultSquare[row][col]);
			}
		}
		int temporary = resultSquare[subSquareMiddle][subSquareMiddle];
		resultSquare[subSquareMiddle][subSquareMiddle] = resultSquare[subSquareMiddle + middle][subSquareMiddle];
		resultSquare[subSquareMiddle + middle][subSquareMiddle] = temporary;
		return resultSquare;
	}

	private static void switchRows(int[][] resultSquare, int n) {
		int rigthColsNeedToSwitch;

		rigthColsNeedToSwitch = n / 4 - 1;

		if (rigthColsNeedToSwitch > 0) {
			int middle;
			middle = n / 2;

			for (int colCounter = 0; colCounter < rigthColsNeedToSwitch; colCounter++) {

				int offcetForCol;
				int currentColIndex;

				offcetForCol = 1 + colCounter;

				currentColIndex = resultSquare.length - (offcetForCol);

				for (int row = 0; row < middle; row++) {

					int rowIndexToSwitch;
					rowIndexToSwitch = row + middle; // с каким рядом этой колонки меняем местами

					int temporary = resultSquare[row][currentColIndex];
					resultSquare[row][currentColIndex] = resultSquare[rowIndexToSwitch][currentColIndex];
					resultSquare[rowIndexToSwitch][currentColIndex] = temporary;
				}
			}
		}
	}

	private static int findQuadrantNumber(int row, int col, int middle) {
		if (row < middle) {
			if (col < middle) {
				return 0;
			}
			return 2;
		}
		if (col < middle) {
			return 3;
		}
		return 1;
	}

	private static int[][] generateOddMagicSquare(int n) {
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

//	private static void getPermutations(int i) {
//		int[] array = new int[i];
//		int[] direc = new int[i];
//		for (int j = 0; j < direc.length; j++) {
//			direc[j] = -1;
//		}
//		array = generateArray(3);
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(direc));
//		int a = 1;
//		while (true) {
//			int id = -1;
//
//			for (int j = 0; j < array.length; j++) {
//				if (((direc[j] == -1 && j > 0 && array[j] > array[j - 1])
//						|| (direc[j] == 1 && j < array.length - 1 && array[j] > array[j + 1])) // подвижность
//						&& ((id == -1) || (array[j] > array[id]))) {
//					id = j;
//				}
//			}
//			if (id == -1) {
//				break;
//			}
//			System.out.println(id);
//			a++;
//			for (int j = 0; j < direc.length; j++) {
//				if (array[j] > array[id]) {
//					direc[j] *= -1;
//				}
//			}
//			int temp = array[id];
//			int tempnapr = direc[id];
//			if (tempnapr == -1) {
//				array[id] = array[id - 1];
//				array[id - 1] = temp;
//				direc[id] = direc[id - 1];
//				direc[id - 1] = tempnapr;
//			} else {
//				array[id] = array[id + 1];
//				array[id + 1] = temp;
//				direc[id] = direc[id + 1];
//				direc[id + 1] = tempnapr;
//			}
//			System.out.println("temp " + temp);
//			System.out.println(a);
//			System.out.println(Arrays.toString(array));
//			System.out.println(Arrays.toString(direc));
//			if (isMagic(array, 4)) {
//				System.out.println("NKNN");
//				System.out.println(Arrays.toString(array));
//				break;
//			}
//		}
//	}

	private static boolean isMagic(int[] array, int n) {
		int summmmmm = n * (n * n + 1) / 2;
		int prevSum = 0;
		for (int i = 0; i < n; i++) {
			prevSum += array[i];
		}
		for (int i = 0; i < array.length; i += n) {
			int sum = 0;
			for (int j = i; j < i + n; j++) {
				sum += array[j];
			}
			if (sum != prevSum) {
				return false;
			}
			// System.out.println(sum);

		}

		prevSum = 0;
		for (int i = 0; i < array.length; i += n) {
			prevSum += array[i];
		}
		System.out.println("prev " + prevSum);
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < array.length; j += n) {
				sum += array[j];

			}
			// System.out.println(prevSum);
			// System.out.println(sum);
			if (sum != prevSum) {
				return false;
			}
		}
		int diagonalSum = 0;
		for (int i = 0; i < n; i++) {
			diagonalSum += array[i * (n + 1)];
		}
		if (diagonalSum != summmmmm) {
			return false;
		}
		diagonalSum = 0;
		for (int i = 0; i < n; i++) {
			diagonalSum += array[(n - 1) * (i + 1)];
		}
		if (diagonalSum != summmmmm) {
			return false;
		}

		return true;
	}

	private static int[][] generateAscendingMatrix(int n) {
		int[][] matrix;

		matrix = new int[n][n];

		int count;
		count = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = count++;
			}
		}

		return matrix;
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
