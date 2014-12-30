package edu.indiana.cs.c212.gameMechanics;

import java.util.ArrayList;
import java.util.Random;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.players.Player;

public class RandomPlayerRules extends StandardRules {

	public RandomPlayerRules(Board board, Player red, Player blue) {
		super(board, red, blue);
		playersQueue.clear();
		playersQueue.add(nextTurn());
		playersQueue.add(nextTurn());
	}

	@Override
	public Player nextTurn() {
		Random randomNumberSource = new Random();
		int randomNumber = randomNumberSource.nextInt(2);
		if (randomNumber < 1) {
			playersQueue.add(blue);
			playersQueue.remove();
			return blue;
		} else {
			playersQueue.add(red);
			playersQueue.remove();
			return red;
		}
	}

	@Override
	public boolean isLegalMove(Move m) {
		int x = m.getX();
		int y = m.getY();
		if (x < board.getSize() && y < board.getSize() && x > -1 && y > -1) {
			if (board.getTileAt(x, y).getColor().equals(PlayerColor.BLANK)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public ArrayList<Move> getLegalMoves(Player player) {
		ArrayList<Move> legalMovesList = new ArrayList<Move>();
		for (int x = 0; x < board.getSize(); x++) {
			for (int y = 0; y < board.getSize(); y++) {
				Move move = new Move(x, y);
				if (isLegalMove(move)) {
					legalMovesList.add(move);
				}
			}
		}
		return legalMovesList;
	}

}
