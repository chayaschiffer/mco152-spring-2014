package schiffer.checkers;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CheckerBoardTest {

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringOnEmptyBoard() {
		final CheckerBoard board = new CheckerBoard();
		final String expected = "--------\n" + "--------\n" + "--------\n"
				+ "--------\n" + "--------\n" + "--------\n" + "--------\n"
				+ "--------\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}// eight rows of dashes
		// empty square is a dash

	@Test
	/**
	 * Your code must pass this test. Do not edit this test.
	 */
	public void testToStringAfterNewGame() {
		final CheckerBoard board = new CheckerBoard();
		board.resetNewGame();
		final String expected = "-w-w-w-w\n" + "w-w-w-w-\n" + "-w-w-w-w\n"
				+ "--------\n" + "--------\n" + "r-r-r-r-\n" + "-r-r-r-r\n"
				+ "r-r-r-r-\n";
		Assert.assertEquals(expected.trim(), board.toString().trim());
	}

	@Test
	/**
	 * Test that isOnBoard() returns the correct result for different xs and ys
	 */
	public void testIsOnBoard() {
		CheckerBoard aboard = new CheckerBoard();
		Assert.assertTrue(aboard.isOnBoard(1, 1));
		Assert.assertFalse(aboard.isOnBoard(9, 9));
		Assert.assertTrue(aboard.isOnBoard(4, 4));
		Assert.assertTrue(aboard.isOnBoard(0, 0));
		Assert.assertTrue(aboard.isOnBoard(5, 5));
		Assert.assertFalse(aboard.isOnBoard(15, 15));

	}

	@Test
	/**
	 * Test that isEmptySquare() returns the correct result before and after setPiece() is called
	 */
	public void testIsEmptySquare() {
		CheckerBoard aboard = new CheckerBoard();
		Assert.assertTrue(aboard.isEmptySquare(4, 4));
		aboard.setPiece(4, 4, Piece.RED_MAN);
		Assert.assertFalse(aboard.isEmptySquare(4, 4));
	}

	@Test
	/**
	 * Given an board with pieces, test that calling clear() clears the board
	 */
	public void testClear() {

		CheckerBoard aboard = new CheckerBoard();
		aboard.clear();
		int empty = 0;
		for (int i = 0; i < aboard.HEIGHT; i++) {
			for (int j = 0; j < aboard.WIDTH; j++) {
				if (!aboard.isEmptySquare(i, j)) {
					empty++;
				}
			}

		}
		Assert.assertEquals(empty, 0);
	}

	@Test
	/**
	 * Test that the board is in the correct configuration after
	 * resetNewGame() is called
	 */
	public void testResetNewGame() {
		CheckerBoard aboard = new CheckerBoard();
		aboard.resetNewGame();
		Assert.assertEquals(aboard.getPiece(1, 0), Piece.WHITE_MAN);

		Assert.assertEquals(aboard.getPiece(3, 0), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(5, 0), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(7, 0), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(0, 1), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(2, 1), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(4, 1), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(6, 1), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(1, 2), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(3, 2), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(5, 2), Piece.WHITE_MAN);
		Assert.assertEquals(aboard.getPiece(7, 2), Piece.WHITE_MAN);

		Assert.assertEquals(aboard.getPiece(0, 7), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(2, 7), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(4, 7), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(6, 7), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(1, 6), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(3, 6), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(5, 6), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(7, 6), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(0, 5), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(2, 5), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(4, 5), Piece.RED_MAN);
		Assert.assertEquals(aboard.getPiece(6, 5), Piece.RED_MAN);
	}

	@Test
	/**
	 * Test execute(Move) moves a piece from one square to the other
	 */
	public void testMove() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 3, Piece.RED_MAN);
		Move move = new Move(2, 3, 4, 3);
		board.execute(move);
		Assert.assertEquals(board.getPiece(4, 3), Piece.RED_MAN);

	}

	@Test
	/**
	 * Test execute(Move) promotes a WHITE_MAN to a WHITE_KING when moving to the 8th row
	 */
	public void testMovePromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 6, Piece.WHITE_MAN);
		Move move = new Move(7, 6, 6, 7);
		board.execute(move);
		Assert.assertEquals(board.getPiece(6, 7), Piece.WHITE_KING);
	}

	@Test
	/**
	 * Test execute(Move) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testMovePromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(6, 1, Piece.RED_MAN);
		Move move = new Move(6, 1, 7, 0);
		board.execute(move);
		Assert.assertEquals(board.getPiece(7, 0), Piece.RED_KING);
	}

	@Test
	/**
	 * Test execute(Jump) moves a piece from one square to another AND removes the piece that was jumped
	 */
	public void testJump() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(4, 3, Piece.RED_MAN);
		Jump jump = new Jump(4, 3, 5, 2, 6, 1);
		board.execute(jump);
		Assert.assertEquals(board.getPiece(6, 1), Piece.RED_MAN);
		Assert.assertEquals(board.getPiece(4, 3), null);
		Assert.assertEquals(board.getPiece(5, 2), null);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a RED_MAN to a RED_KING when moving to the 1st row
	 */
	public void testJumpPromoteToRedKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(5, 2, Piece.RED_MAN);
		Jump jump = new Jump(5, 2, 6, 1, 7, 0);
		board.execute(jump);
		Assert.assertEquals(board.getPiece(7, 0), Piece.RED_KING);
		Assert.assertEquals(board.getPiece(5, 2), null);
		Assert.assertEquals(board.getPiece(6, 1), null);
	}

	@Test
	/**
	 * Test execute(Jump) promotes a WHITE_MAN to a WHITE_KING when moving to the 1st row
	 */
	public void testJumpPromoteToWhiteKing() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_MAN);
		Jump jump = new Jump(2, 5, 1, 6, 0, 7);
		board.execute(jump);
		Assert.assertEquals(board.getPiece(0, 7), Piece.WHITE_KING);
		Assert.assertEquals(board.getPiece(2, 5), null);
		Assert.assertEquals(board.getPiece(1, 6), null);
	}

	@Test
	/**
	 * Test that getMoves() returns the correct number of Move objects when called on an empty square
	 */
	public void testGetMovesForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Move> moves = (ArrayList<Move>) board.getMoves(2, 5);
		Assert.assertTrue(moves.isEmpty());
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_MAN);
		List<Move> moves = (ArrayList<Move>) board.getMoves(2, 5);
		// normally, i would do this,
		// however, i overheard you telling a student
		// that we should be careful with the contains method
		// with objects
		Assert.assertTrue(moves.contains(new Move(2, 5, 3, 4)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 1, 4)));
		Assert.assertTrue(moves.size() == 2);
		Assert.assertTrue(moves.get(0).equals(new Move(2, 5, 3, 4)));
		Assert.assertTrue(moves.get(1).equals(new Move(2, 5, 1, 4)));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		List<Move> moves = (ArrayList<Move>) board.getMoves(2, 5);
		// normally, i would do the first two asserts.
		// however, i overheard you telling a student
		// that we should be careful with the contains method
		// with objects
		Assert.assertTrue(moves.size() == 4);

		Assert.assertTrue(moves.get(0).equals(new Move(2, 5, 3, 4)));
		Assert.assertTrue(moves.get(1).equals(new Move(2, 5, 1, 4)));
		Assert.assertTrue(moves.get(2).equals(new Move(2, 5, 1, 6)));
		Assert.assertTrue(moves.get(3).equals(new Move(2, 5, 3, 6)));

		Assert.assertTrue(moves.contains(new Move(2, 5, 3, 4)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 1, 4)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 1, 6)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 3, 6)));

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a WHITE_MAN is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteManInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_MAN);
		List<Move> moves = (ArrayList<Move>) board.getMoves(2, 5);

		Assert.assertTrue(moves.contains(new Move(2, 5, 3, 6)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 1, 6)));
		Assert.assertTrue(moves.size() == 2);
		Assert.assertTrue(moves.get(0).equals(new Move(2, 5, 1, 6)));
		Assert.assertTrue(moves.get(1).equals(new Move(2, 5, 3, 6)));
	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a WHITE_KING is in the middle of an otherwise
	 * empty board
	 */
	public void testGetMovesForWhiteKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.WHITE_KING);
		List<Move> moves = (ArrayList<Move>) board.getMoves(2, 5);

		Assert.assertTrue(moves.size() == 4);

		Assert.assertTrue(moves.get(0).equals(new Move(2, 5, 3, 4)));
		Assert.assertTrue(moves.get(1).equals(new Move(2, 5, 1, 4)));
		Assert.assertTrue(moves.get(2).equals(new Move(2, 5, 1, 6)));
		Assert.assertTrue(moves.get(3).equals(new Move(2, 5, 3, 6)));

		Assert.assertTrue(moves.contains(new Move(2, 5, 3, 4)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 1, 4)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 1, 6)));
		Assert.assertTrue(moves.contains(new Move(2, 5, 3, 6)));

	}

	@Test
	/**
	 * Test that getMoves() returns the correct Move objects when a RED_KING is surrounded in 4 directions and
	 * cannot move.
	 * This should be an empty List
	 */
	public void testGetMovesForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		board.setPiece(3, 4, Piece.RED_MAN);
		board.setPiece(1, 4, Piece.RED_MAN);
		board.setPiece(3, 6, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.WHITE_KING);
		List<Move> moves = (ArrayList<Move>) board.getMoves(2, 5);
		Assert.assertTrue(moves.isEmpty());

	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (0,7) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt07() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(0, 7, Piece.RED_KING);
		List<Move> moves = (ArrayList<Move>) board.getMoves(0, 7);
		Assert.assertTrue(moves.size() == 1);
		Assert.assertTrue(moves.contains(new Move(0, 7, 1, 6)));
		Assert.assertTrue(moves.get(0).equals(new Move(0, 7, 1, 6)));
	}

	@Test
	/**
	 * Test that when getMoves() is called for a piece at the EDGE of the board (7,0) then the correct
	 * move is returned.
	 */
	public void testGetMovesForRedKingAt70() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(7, 0, Piece.RED_KING);
		List<Move> moves = (ArrayList<Move>) board.getMoves(7, 0);
		Assert.assertTrue(moves.size() == 1);
		Assert.assertTrue(moves.contains(new Move(7, 0, 6, 1)));
		Assert.assertTrue(moves.get(0).equals(new Move(7, 0, 6, 1)));
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on an empty square
	 */
	public void testGetJumpsForEmptySquare() {
		CheckerBoard board = new CheckerBoard();
		List<Jump> jumps = (ArrayList<Jump>) board.getJumps(2, 2);
		Assert.assertTrue(jumps.isEmpty());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct number of Jump objects when called on square that does not have
	 * any possible jumps
	 */
	public void testGetJumpsForRedKingInMiddleOfEmptyBoard() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 2, Piece.RED_KING);
		List<Jump> jumps = (ArrayList<Jump>) board.getJumps(2, 2);
		Assert.assertTrue(jumps.isEmpty());
	}

	@Test
	/**
	 * Test that getJumps() returns the correct Jump objects when a King can jump in 4 directions
	 */
	public void testGetJumpsForRedKingWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_KING);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_MAN);
		board.setPiece(1, 6, Piece.WHITE_MAN);
		board.setPiece(3, 6, Piece.WHITE_MAN);
		List<Jump> jumps = (ArrayList<Jump>) board.getJumps(2, 5);

		Assert.assertTrue(jumps.size() == 4);

		Assert.assertTrue(jumps.contains(new Jump(2, 5, 3, 4, 4, 3)));
		Assert.assertTrue(jumps.contains(new Jump(2, 5, 1, 4, 0, 3)));
		Assert.assertTrue(jumps.contains(new Jump(2, 5, 1, 6, 0, 7)));
		Assert.assertTrue(jumps.contains(new Jump(2, 5, 3, 6, 4, 7)));

	}

	@Test
	/**
	 * Test that getJumps() returns the returns the correct Jump objects when a Piece can jump in 2 directions
	 */
	public void testGetJumpsForRedManWhenSurrounded() {
		CheckerBoard board = new CheckerBoard();
		board.setPiece(2, 5, Piece.RED_MAN);
		board.setPiece(3, 4, Piece.WHITE_MAN);
		board.setPiece(1, 4, Piece.WHITE_MAN);

		List<Jump> jumps = (ArrayList<Jump>) board.getJumps(2, 5);

		Assert.assertTrue(jumps.size() == 2);
		Assert.assertTrue(jumps.contains(new Jump(2, 5, 3, 4, 4, 3)));
		Assert.assertTrue(jumps.contains(new Jump(2, 5, 1, 4, 0, 3)));

	}

}
