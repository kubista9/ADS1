public class NQueensProblem {
	private int[] board;
	private int chessboardSize;

	public NQueensProblem(int chessboardSize) {
		this.chessboardSize = chessboardSize;
		this.board = new int[chessboardSize];
		for (int i = 0; i < chessboardSize; i++) {
			board[i] = -1;
		}
	}

	public void solve() {
		if (placeQueens(0)) {
			printSolution();
		} else {
			System.out.println("No solution found.");
		}
	}

	private boolean placeQueens(int row) {
		if (row == chessboardSize) {
			printSolution(); // Print the solution when a valid configuration is found
			System.out.println("------------------------");
			System.out.println("----Correct solution----");
			return true;
		}

		for (int col = 0; col < chessboardSize; col++) {
			if (isSafe(row, col)) {
				board[row] = col;
				printSolution(); // Print the current state of the board
				System.out.println("-----------------------");
				if (placeQueens(row + 1)) {
					return true;
				}
				// Backtrack
				board[row] = -1;
			}
		}
		return false;
	}


	private boolean isSafe(int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

	private void printSolution() {
		for (int i = 0; i < chessboardSize; i++) {
			for (int j = 0; j < chessboardSize; j++) {
				if (board[i] == j) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}
}
