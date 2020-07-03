package by.epamtc.zhurava.lesson4.task06;

public class MagicSquare {

	public static void main(String[] args) {

		int n;
		int[][] magicSquare;

		n = 8;

		if (n % 2 == 1) {
			magicSquare = generateOddMagicSquare(n);

		} else if (n % 4 != 0) {

			magicSquare = generateOneEvenMagicSquare(n);
		} else {
			magicSquare = generateTwoEvenSquare(n);
		}

		printMatrix(magicSquare);

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

	private static int[][] generateOneEvenMagicSquare(int n) {

		int[][] resultSquare;
		resultSquare = new int[n][n];

		int subquadrantSize;
		subquadrantSize = n / 2;

		int[][] subQuadrant;
		subQuadrant = generateOddMagicSquare(subquadrantSize);

		for (int row = 0; row < n; row++) {

			for (int col = 0; col < n; col++) {

				int numberFromSubquadrant;
				int quadrantNumber;
				int adding;
				int offset;

				numberFromSubquadrant = subQuadrant[row % subquadrantSize][col % subquadrantSize];

				quadrantNumber = findQuadrantNumber(row, col, subquadrantSize);

				offset = subquadrantSize * subquadrantSize;

				adding = offset * quadrantNumber;

				resultSquare[row][col] = numberFromSubquadrant + adding;
			}
		}

		switchRows(resultSquare, n);

		switchLeftBlock(resultSquare);

		return resultSquare;
	}

	private static void switchLeftBlock(int[][] resultSquare) {

		int magicSquareMiddle;
		int subSquareMiddle;

		magicSquareMiddle = resultSquare.length / 2;

		subSquareMiddle = magicSquareMiddle / 2;

		for (int row = 0; row < magicSquareMiddle; row++) {

			int rowToSwitch;
			int startPointAtRow;

			rowToSwitch = row + magicSquareMiddle;

			if (row != subSquareMiddle) {
				startPointAtRow = 0;

			} else {
				startPointAtRow = 1;
			}

			for (int col = startPointAtRow; col < subSquareMiddle; col++) {

				int temporary = resultSquare[row][col];

				resultSquare[row][col] = resultSquare[rowToSwitch][col];

				resultSquare[rowToSwitch][col] = temporary;
			}
		}

		int temporary = resultSquare[subSquareMiddle][subSquareMiddle];
		int offset = subSquareMiddle + magicSquareMiddle;

		resultSquare[subSquareMiddle][subSquareMiddle] = resultSquare[offset][subSquareMiddle];

		resultSquare[offset][subSquareMiddle] = temporary;

	}

	private static int[][] generateTwoEvenSquare(int n) {

		int[][] resultSquare;
		resultSquare = generateAscendingMatrix(n);

		int reverceCounter;
		reverceCounter = n * n;

		replaceNumbersWithNulsWhereNeeded(resultSquare);

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

	private static void replaceNumbersWithNulsWhereNeeded(int[][] resultSquare) {

		int n;
		int half;
		int quater;
		int threeQuaters;

		n = resultSquare.length;
		half = n / 2;
		quater = n / 4;
		threeQuaters = quater + half;

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

	private static int[][] generateAscendingMatrix(int n) {

		int[][] matrix;
		matrix = new int[n][n];

		int count;
		count = 1;

		for (int row = 0; row < n; row++) {

			for (int col = 0; col < n; col++) {
				matrix[row][col] = count++;
			}
		}
		return matrix;
	}

	private static void printMatrix(int[][] matrix) {

		for (int row = 0; row < matrix.length; row++) {

			for (int col = 0; col < matrix[row].length; col++) {

				System.out.printf("%3d ", matrix[row][col]);
			}
			System.out.println();
		}

	}

//	private static void getPermutations(int i) {
//	int[] array = new int[i];
//	int[] direc = new int[i];
//	for (int j = 0; j < direc.length; j++) {
//		direc[j] = -1;
//	}
//	array = generateArray(3);
//	System.out.println(Arrays.toString(array));
//	System.out.println(Arrays.toString(direc));
//	int a = 1;
//	while (true) {
//		int id = -1;
//
//		for (int j = 0; j < array.length; j++) {
//			if (((direc[j] == -1 && j > 0 && array[j] > array[j - 1])
//					|| (direc[j] == 1 && j < array.length - 1 && array[j] > array[j + 1])) // подвижность
//					&& ((id == -1) || (array[j] > array[id]))) {
//				id = j;
//			}
//		}
//		if (id == -1) {
//			break;
//		}
//		System.out.println(id);
//		a++;
//		for (int j = 0; j < direc.length; j++) {
//			if (array[j] > array[id]) {
//				direc[j] *= -1;
//			}
//		}
//		int temp = array[id];
//		int tempnapr = direc[id];
//		if (tempnapr == -1) {
//			array[id] = array[id - 1];
//			array[id - 1] = temp;
//			direc[id] = direc[id - 1];
//			direc[id - 1] = tempnapr;
//		} else {
//			array[id] = array[id + 1];
//			array[id + 1] = temp;
//			direc[id] = direc[id + 1];
//			direc[id + 1] = tempnapr;
//		}
//		System.out.println("temp " + temp);
//		System.out.println(a);
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(direc));
//		if (isMagic(array, 4)) {
//			System.out.println("NKNN");
//			System.out.println(Arrays.toString(array));
//			break;
//		}
//	}
//}

}
