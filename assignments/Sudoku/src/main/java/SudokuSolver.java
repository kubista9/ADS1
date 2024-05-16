import java.util.Arrays;

public class SudokuSolver {

	public static int[][] whichSquare(int m, int n) {
		int a = (m / 3) * 3;
		int b = (n / 3) * 3;
		int[][] square = new int[][] {
				{a, b}, {a, b + 1}, {a, b + 2},
				{a + 1, b}, {a + 1, b + 1}, {a + 1, b + 2},
				{a + 2, b}, {a + 2, b + 1}, {a + 2, b + 2}
		};
		return square;
	}

	public static boolean checkIfOkay(int[][] sudoku, int m, int n, int k) {
		int currentNumber = k;
		for (int i = 0; i < 9; i++) {
			if (sudoku[m][i] == currentNumber && i != n) {
				return false;
			}
			if (sudoku[i][n] == currentNumber && i != m) {
				return false;
			}
		}
		int[][] square = whichSquare(m, n);
		for (int[] s : square) {
			if (sudoku[s[0]][s[1]] == currentNumber && !Arrays.equals(s, new int[]{m, n})) {
				return false;
			}
		}
		return true;
	}

	public static int[] findEmpty(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sudoku[i][j] == 0) {
					return new int[]{i, j};
				}
			}
		}
		return new int[]{-1, -1};
	}

	public static boolean solveSudoku(int[][] sudoku) {
		int[] empty = findEmpty(sudoku);
		int i = empty[0];
		int j = empty[1];
		if (i == -1 && j == -1) {
			return true;
		}
		for (int k = 1; k <= 9; k++) {
			if (checkIfOkay(sudoku, i, j, k)) {
				sudoku[i][j] = k;
				if (solveSudoku(sudoku)) {
					return true;
				}
				sudoku[i][j] = 0;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// Example usage
		int[][] sudoku = new int[][]{
				{5, 3, 0, 0, 7, 0, 0, 0, 0},
				{6, 0, 0, 1, 9, 5, 0, 0, 0},
				{0, 9, 8, 0, 0, 0, 0, 6, 0},
				{8, 0, 0, 0, 6, 0, 0, 0, 3},
				{4, 0, 0, 8, 0, 3, 0, 0, 1},
				{7, 0, 0, 0, 2, 0, 0, 0, 6},
				{0, 6, 0, 0, 0, 0, 2, 8, 0},
				{0, 0, 0, 4, 1, 9, 0, 0, 5},
				{0, 0, 0, 0, 8, 0, 0, 7, 9}
		};

		if (solveSudoku(sudoku)) {
			for (int[] row : sudoku) {
				for (int num : row) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("No solution exists");
		}
	}
}
