public class NQueenProblem {
	private int[][] chessboard;
	private int chessboardSize;
	public NQueenProblem(int chessboardSize){
		this.chessboard = new int[chessboardSize][chessboardSize];
		this.chessboardSize = chessboardSize;
	}

	public void printChessboard(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] == 1) {
					System.out.print(" Q ");
				} else {
					System.out.print(" - ");
				}
			}
			System.out.println();
		}
	}

	private boolean isSafe(int row, int col) {
		// Check this row on left side
		for (int i = 0; i < col; i++) {
			if (chessboard[row][i] == 1) {
				return false;
			}
		}

		// Check upper diagonal on left side
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (chessboard[i][j] == 1) {
				return false;
			}
		}

		// Check lower diagonal on left side
		for (int i = row, j = col; j >= 0 && i < chessboardSize; i++, j--) {
			if (chessboard[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	//Method gets its argument for row from the recursive calls within the method itself
	private boolean placeQueens(int row){
		if (row == chessboardSize){ //base for recursion, when row = chessboardSize it indicates that all queens have been placed
			return true;
		}
		for (int col = 0; col < chessboardSize; col++){ //for each column
			if (isSafe(row, col)){
				chessboard[row][col] = 1; //place queen
				if (placeQueens(row + 1)){ //recursive call. If returns true, it means that a queen has been successfully placed in every row up to and including the next row, indicating that a valid solution has been found.
					return true;
				}
				//backtrack
				chessboard[row][col] = 0; //remove queen
				printChessboard(chessboard);
				System.out.println("-----------------");
			}
		}
		return false;
	}

	public void solve() {
		if (placeQueens(0)) {
			printChessboard(chessboard);
		} else {
			System.out.println("No solution found.");
		}
	}


	public static void main(String[] args){
		NQueenProblem nQueenProblem = new NQueenProblem(8);
		nQueenProblem.solve();
	}
}
