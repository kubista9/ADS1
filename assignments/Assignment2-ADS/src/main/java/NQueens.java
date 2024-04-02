public class NQueens {
	private int[] board;
	private int N;

	public NQueens(int N) {
		this.N = N;
		this.board = new int[N];
		for (int i = 0; i < N; i++) {
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
		if (row == N) {
			return true;
		}

		for (int col = 0; col < N; col++) {
			if (isSafe(row, col)) {
				board[row] = col;
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
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i] == j) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		NQueens nQueens = new NQueens(8);
		nQueens.solve();
	}
}
