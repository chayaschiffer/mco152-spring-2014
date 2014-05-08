package schiffer.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Evaluator {
	private TicTacToeBoard aboard;
	private Symbol winner;
	private List<Location> winningsquareslist;

	public Evaluator(TicTacToeBoard aboard) {
		this.aboard = aboard;
		this.winner = null;
		winningsquareslist = new ArrayList<Location>();
	}

	public void evaluate() {
		Location loc1;
		Location loc2;
		Location loc3;

		// test horizontal
		for (int i = 0; i < 3; i++) {
			loc1 = new Location(i, 0);
			loc2 = new Location(i, 1);
			loc3 = new Location(i, 2);

			if (aboard.getSquare(loc1) != null
					&& aboard.getSquare(loc2) != null
					&& aboard.getSquare(loc3) != null) {
				if (aboard.getSquare(loc1).equals(aboard.getSquare(loc2))
						&& aboard.getSquare(loc2)
								.equals(aboard.getSquare(loc3))) {
					winner = aboard.getSquare(loc1);
					winningsquareslist.add(loc1);
					winningsquareslist.add(loc2);
					winningsquareslist.add(loc3);
					return;
				}
			}
		}

		// test vertical

		for (int i = 0; i < 3; i++) {
			loc1 = new Location(0, i);
			loc2 = new Location(1, i);
			loc3 = new Location(2, i);

			if (aboard.getSquare(loc1) != null
					&& aboard.getSquare(loc2) != null
					&& aboard.getSquare(loc3) != null) {
				if (aboard.getSquare(loc1).equals(aboard.getSquare(loc2))
						&& aboard.getSquare(loc2)
								.equals(aboard.getSquare(loc3))) {
					winner = aboard.getSquare(loc1);
					winningsquareslist.add(loc1);
					winningsquareslist.add(loc2);
					winningsquareslist.add(loc3);
					return;
				}
			}
		}

		// test diagonal
		loc1 = new Location(0, 0);
		loc2 = new Location(1, 1);
		loc3 = new Location(2, 2);

		if (aboard.getSquare(loc1) != null && aboard.getSquare(loc2) != null
				&& aboard.getSquare(loc3) != null) {
			if (aboard.getSquare(loc1).equals(aboard.getSquare(loc2))
					&& aboard.getSquare(loc2).equals(aboard.getSquare(loc3))) {
				winner = aboard.getSquare(loc1);
				winningsquareslist.add(loc1);
				winningsquareslist.add(loc2);
				winningsquareslist.add(loc3);
				return;
			}
		}

		// test other diagonal
		loc1 = new Location(0, 2);
		loc2 = new Location(1, 1);
		loc3 = new Location(2, 0);

		if (aboard.getSquare(loc1) != null && aboard.getSquare(loc2) != null
				&& aboard.getSquare(loc3) != null) {
			if (aboard.getSquare(loc1).equals(aboard.getSquare(loc2))
					&& aboard.getSquare(loc2).equals(aboard.getSquare(loc3))) {
				winner = aboard.getSquare(loc1);
				winningsquareslist.add(loc1);
				winningsquareslist.add(loc2);
				winningsquareslist.add(loc3);
			}
		}

	}

	public Symbol getWinner() {
		if (winner != null) {
			return winner;
		} else {
			return null;
		}
	}

	public List<Location> getWinningSquares() {
		if (winner != null) {
			return winningsquareslist;
		} else {
			return null;
		}
	}

	public void resetGame() {
		this.winner = null;
		this.winningsquareslist = new ArrayList<Location>();
		aboard.reset();
	}

}
