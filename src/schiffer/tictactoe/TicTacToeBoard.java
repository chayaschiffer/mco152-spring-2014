package schiffer.tictactoe;

public class TicTacToeBoard {

	private Symbol[][] board;

	public TicTacToeBoard() {
		board = new Symbol[3][3];
	}

	public void reset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = null;
			}
		}
	}

	public boolean isFull() {
		int numFilledSquares = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null) {
					numFilledSquares++;
				}
			}
		}
		if (numFilledSquares == board.length * board[0].length) {
			return true;
		}
		return false;
	}

	public void setSquare(Location l, Symbol s) {
		board[l.getX()][l.getY()] = s;
	}

	public Symbol getSquare(Location l) {
		return board[l.getX()][l.getY()];
	}
}
