package schiffer.checkers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of a game of Checkers should match
 * http://simple.wikipedia.org/wiki/Checkers
 * 
 * How to play Checkers: https://www.youtube.com/watch?v=SuQY1_fCVsA
 */
public class CheckerBoard {

	public static final int WIDTH = 8;
	public static final int HEIGHT = 8;
	private final Piece[][] board;

	public CheckerBoard() {
		// height is y value, width is x value
		this.board = new Piece[HEIGHT][WIDTH];
	}

	public Piece getPiece(final int x, final int y) {
		return board[y][x];
	}

	public void setPiece(final int x, final int y, final Piece piece) {
		board[y][x] = piece;
	}

	public void removePiece(final int x, final int y) {
		setPiece(x, y, null);
	}

	/**
	 * Returns true if the x,y coordinate is within the 8x8 board, otherwise
	 * false
	 */
	public boolean isOnBoard(final int x, final int y) {
		return y < HEIGHT && y >= 0 && x < WIDTH && x >= 0;

	}

	/**
	 * Returns true if the square is null, otherwise false
	 */
	public boolean isEmptySquare(final int x, final int y) {
		return board[y][x] == null;

	}

	/**
	 * Removes all pieces from the board
	 */
	public void clear() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = null;
			}
		}
	}

	/**
	 * Sets the board to a starting configuration
	 */
	public void resetNewGame() {

		setPiece(1, 0, Piece.WHITE_MAN);
		setPiece(3, 0, Piece.WHITE_MAN);
		setPiece(5, 0, Piece.WHITE_MAN);
		setPiece(7, 0, Piece.WHITE_MAN);
		setPiece(0, 1, Piece.WHITE_MAN);
		setPiece(2, 1, Piece.WHITE_MAN);
		setPiece(4, 1, Piece.WHITE_MAN);
		setPiece(6, 1, Piece.WHITE_MAN);
		setPiece(1, 2, Piece.WHITE_MAN);
		setPiece(3, 2, Piece.WHITE_MAN);
		setPiece(5, 2, Piece.WHITE_MAN);
		setPiece(7, 2, Piece.WHITE_MAN);

		setPiece(0, 7, Piece.RED_MAN);
		setPiece(2, 7, Piece.RED_MAN);
		setPiece(4, 7, Piece.RED_MAN);
		setPiece(6, 7, Piece.RED_MAN);
		setPiece(1, 6, Piece.RED_MAN);
		setPiece(3, 6, Piece.RED_MAN);
		setPiece(5, 6, Piece.RED_MAN);
		setPiece(7, 6, Piece.RED_MAN);
		setPiece(0, 5, Piece.RED_MAN);
		setPiece(2, 5, Piece.RED_MAN);
		setPiece(4, 5, Piece.RED_MAN);
		setPiece(6, 5, Piece.RED_MAN);

	}

	@Override
	/**
	 * Returns a String representation of the board. Each row of the board should be on it's own line.
	 * A dash "-" represents an empty square. Pieces should be displayed using the .toString() method
	 * of the piece class.
	 */
	public String toString() {
		StringBuilder theBoard = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != null) {
					theBoard.append(board[i][j].toString());
				} else {
					theBoard.append("-");
				}
			}
			theBoard.append("\n");
		}
		return theBoard.toString();
	}

	/**
	 * Do the Move, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. If the piece is now on their "King's Row", then promote the piece
	 * should be promoted to a King
	 */
	public void execute(final Move move) {
		Piece thePiece = getPiece(move.getX1(), move.getY1());
		setPiece(move.getX1(), move.getY1(), null);
		// red man's turn
		if (thePiece == Piece.RED_MAN) {
			if (move.getY2() == 0) {
				setPiece(move.getX2(), move.getY2(), Piece.RED_KING);
			} else {// not doing king move
				setPiece(move.getX2(), move.getY2(), thePiece);
			}
		}
		// white man's turn
		else {
			if (move.getY2() == 7) {
				setPiece(move.getX2(), move.getY2(), Piece.WHITE_KING);
			} else {
				setPiece(move.getX2(), move.getY2(), thePiece);
			}
		}

	}

	/**
	 * Do the Jump, removing the piece from x1, y1 and setting the piece in x2,
	 * y2. Remove the piece from captureX, captureY as well. If the piece is now
	 * on their "King's Row", then promote the piece should be promoted to a
	 * King
	 */
	public void execute(final Jump jump) {

		Piece thePiece = getPiece(jump.getX1(), jump.getY1());
		setPiece(jump.getX1(), jump.getY1(), null);
		setPiece(jump.getCaptureX(), jump.getCaptureY(), null);
		// red man's turn
		if (thePiece == Piece.RED_MAN) {
			if (jump.getY2() == 0) {
				setPiece(jump.getX2(), jump.getY2(), Piece.RED_KING);
			} else {// regular jump
				setPiece(jump.getX2(), jump.getY2(), thePiece);
			}
		}
		// white man's turn
		else {
			if (jump.getY2() == 7) {
				setPiece(jump.getX2(), jump.getY2(), Piece.WHITE_KING);
			} else {
				setPiece(jump.getX2(), jump.getY2(), thePiece);
			}
		}

	}

	/**
	 * Returns a list of all possible moves from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal move then
	 * return an empty list
	 */
	public List<Move> getMoves(final int x, final int y) {
		List<Move> moves = new ArrayList<Move>();
		Piece piece = getPiece(x, y);
		if (piece != null) {// there is a piece on that square{
			if (piece.getColor() == Color.RED) {
				if (piece.isKing()) {
					// can go both ways
					if (isOnBoard(x + 1, y - 1)
							&& getPiece(x + 1, y - 1) == null) {
						Move move = new Move(x, y, x + 1, y - 1);
						moves.add(move);
					}
					if (isOnBoard(x - 1, y - 1)
							&& getPiece(x - 1, y - 1) == null) {
						Move move = new Move(x, y, x - 1, y - 1);
						moves.add(move);
					}
					if (isOnBoard(x - 1, y + 1)
							&& getPiece(x - 1, y + 1) == null) {
						Move move = new Move(x, y, x - 1, y + 1);
						moves.add(move);
					}
					if (isOnBoard(x + 1, y + 1)
							&& getPiece(x + 1, y + 1) == null) {
						Move move = new Move(x, y, x + 1, y + 1);
						moves.add(move);
					}
					if (moves.isEmpty()) {
						return new ArrayList<Move>();
					} else {
						return moves;
					}
				} else {
					if (isOnBoard(x + 1, y - 1)
							&& getPiece(x + 1, y - 1) == null) {
						Move move = new Move(x, y, x + 1, y - 1);
						moves.add(move);
					}
					if (isOnBoard(x - 1, y - 1)
							&& getPiece(x - 1, y - 1) == null) {
						Move move = new Move(x, y, x - 1, y - 1);
						moves.add(move);
					}
					if (moves.isEmpty()) {
						return new ArrayList<Move>();
					} else {
						return moves;
					}

				}

			}

			else {// the piece is white, can only move down
				if (piece.isKing()) {
					if (isOnBoard(x + 1, y - 1)
							&& getPiece(x + 1, y - 1) == null) {
						Move move = new Move(x, y, x + 1, y - 1);
						moves.add(move);
					}
					if (isOnBoard(x - 1, y - 1)
							&& getPiece(x - 1, y - 1) == null) {
						Move move = new Move(x, y, x - 1, y - 1);
						moves.add(move);
					}
					if (isOnBoard(x - 1, y + 1)
							&& getPiece(x - 1, y + 1) == null) {
						Move move = new Move(x, y, x - 1, y + 1);
						moves.add(move);
					}
					if (isOnBoard(x + 1, y + 1)
							&& getPiece(x + 1, y + 1) == null) {
						Move move = new Move(x, y, x + 1, y + 1);
						moves.add(move);
					}
					if (moves.isEmpty()) {
						return new ArrayList<Move>();
					} else {
						return moves;
					}
				} else {
					// can't go both ways
					if (isOnBoard(x - 1, y + 1)
							&& getPiece(x - 1, y + 1) == null) {
						Move move = new Move(x, y, x - 1, y + 1);
						moves.add(move);
					}
					if (isOnBoard(x + 1, y + 1)
							&& getPiece(x + 1, y + 1) == null) {
						Move move = new Move(x, y, x + 1, y + 1);
						moves.add(move);
					}
					if (moves.isEmpty()) {
						return new ArrayList<Move>();
					} else {
						return moves;
					}
				}
			}

		} else {
			return new ArrayList<Move>();
		}

	}

	/**
	 * Returns a list of all possible jumps from the piece at (x,y). If there is
	 * no piece on that square, or the piece cannot make a legal jump then
	 * return an empty list
	 */
	public List<Jump> getJumps(final int x, final int y) {
		List<Jump> jumps = new ArrayList<Jump>();

		Piece piece = getPiece(x, y);
		if (piece != null) {

			if (piece.getColor() == Color.RED) {
				if (piece.isKing()) {
					// can go both ways
					if (isOnBoard(x + 2, y - 2)
							&& getPiece(x + 2, y - 2) == null
							&& getPiece(x + 1, y - 1) != null) {
						Jump jump = new Jump(x, y, x + 1, y - 1, x + 2, y - 2);
						jumps.add(jump);
					}
					if (isOnBoard(x - 2, y - 2)
							&& getPiece(x - 2, y - 2) == null
							&& getPiece(x - 1, y - 1) != null) {
						Jump jump = new Jump(x, y, x - 1, y - 1, x - 2, y - 2);
						jumps.add(jump);
					}
					if (isOnBoard(x + 2, y + 2)
							&& getPiece(x + 2, y + 2) == null
							&& getPiece(x + 1, y + 1) != null) {
						Jump jump = new Jump(x, y, x + 1, y + 1, x + 2, y + 2);
						jumps.add(jump);
					}
					if (isOnBoard(x - 2, y + 2)
							&& getPiece(x - 2, y + 2) == null
							&& getPiece(x - 1, y + 1) != null) {
						Jump jump = new Jump(x, y, x - 1, y + 1, x - 2, y + 2);
						jumps.add(jump);
					}
					if (jumps.isEmpty()) {
						return new ArrayList<Jump>();
					} else {
						return jumps;
					}
				} else {
					if (isOnBoard(x + 2, y - 2)
							&& getPiece(x + 2, y - 2) == null
							&& getPiece(x + 1, y - 1) != null) {
						Jump jump = new Jump(x, y, x + 1, y - 1, x + 2, y - 2);
						jumps.add(jump);
					}
					if (isOnBoard(x - 2, y - 2)
							&& getPiece(x - 2, y - 2) == null
							&& getPiece(x - 1, y - 1) != null) {
						Jump jump = new Jump(x, y, x - 1, y - 1, x - 2, y - 2);
						jumps.add(jump);
					}
					if (jumps.isEmpty()) {
						return new ArrayList<Jump>();
					} else {
						return jumps;
					}

				}

			} else {// white

				if (piece.isKing()) {
					if (isOnBoard(x - 2, y - 2)
							&& getPiece(x - 2, y - 2) == null
							&& getPiece(x - 1, y - 1) != null) {
						Jump jump = new Jump(x, y, x - 1, y - 1, x - 2, y - 2);
						jumps.add(jump);
					}
					if (isOnBoard(x + 2, y - 2)
							&& getPiece(x + 2, y - 2) == null
							&& getPiece(x + 1, y - 1) != null) {
						Jump jump = new Jump(x, y, x + 1, y - 1, x + 2, y - 2);
						jumps.add(jump);
					}

					if (isOnBoard(x - 2, y + 2)
							&& getPiece(x - 2, y + 2) == null
							&& getPiece(x - 1, y + 1) != null) {
						Jump jump = new Jump(x, y, x - 1, y + 1, x - 2, y + 2);
						jumps.add(jump);
					}
					if (isOnBoard(x + 2, y + 2)
							&& getPiece(x + 2, y + 2) == null
							&& getPiece(x + 1, y + 1) != null) {
						Jump jump = new Jump(x, y, x + 1, y + 1, x + 2, y + 2);
						jumps.add(jump);
					}
					if (jumps.isEmpty()) {
						return new ArrayList<Jump>();
					} else {
						return jumps;
					}
				}

				else {
					// can't go both ways
					if (isOnBoard(x - 2, y + 2)
							&& getPiece(x - 2, y + 2) == null
							&& getPiece(x - 1, y + 1) != null) {
						Jump jump = new Jump(x, y, x - 1, y + 1, x - 2, y + 2);
						jumps.add(jump);
					}
					if (isOnBoard(x + 2, y + 2)
							&& getPiece(x + 2, y + 2) == null
							&& getPiece(x + 1, y + 1) != null) {
						Jump jump = new Jump(x, y, x + 1, y + 1, x + 2, y + 2);
						jumps.add(jump);
					}
					if (jumps.isEmpty()) {
						return new ArrayList<Jump>();
					} else {
						return jumps;
					}
				}

			}

		}

		else {// there's no piece on that board
			return new ArrayList<Jump>();
		}
	}

}
