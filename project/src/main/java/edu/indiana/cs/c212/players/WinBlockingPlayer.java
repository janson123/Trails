package edu.indiana.cs.c212.players;

import java.util.List;
import java.util.Random;
import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class WinBlockingPlayer extends AbstractPlayer {

	protected PlayerColor color;
	private String name;
	private int boardSize;
	private Move move;
	private Boolean isFirst;

	public WinBlockingPlayer(PlayerColor c) {
		super(c);
		this.color = c;
		name = "WinBlockingPlayer";
		isFirst = true;
	}

	/*
	 * Not completed class. Isn't really a winblocking player yet.
	 * 
	 * 
	 *
	 * 
	 */
	
	
	
	
	
	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		int boardSize = board.getSize();
		this.boardSize = boardSize;

		if (color.equals(PlayerColor.BLUE)) {
			for (int x = 0; x < boardSize; x++) {
				if (board.getTileAt(x, 1).getColor().equals(PlayerColor.RED)) {
					if (board.getTileAt(x, 0).getColor()
							.equals(PlayerColor.BLANK)) {
						return new Move(x, 0);
					} else {
						Random randomNumberSource = new Random();
						int randomNumber = randomNumberSource
								.nextInt(legalMoves.size());
						return legalMoves.get(randomNumber);
					}
				} else if (board.getTileAt(x, boardSize - 2).getColor()
						.equals(PlayerColor.RED)) {
					if (board.getTileAt(x, boardSize - 1).getColor()
							.equals(PlayerColor.BLANK)) {
						// this.move = new Move(x, boardSize - 1);
						return new Move(x, boardSize - 1);
					} else{
						Random randomNumberSource = new Random();
						int randomNumber = randomNumberSource.nextInt(legalMoves
								.size());
						return legalMoves.get(randomNumber);
					}
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			}
		}

		if (color.equals(PlayerColor.RED)) {
			if (isFirst == true) {
				Random randomNumberSource = new Random();
				int randomNumber = randomNumberSource
						.nextInt(legalMoves.size());
				this.isFirst = false;
				return legalMoves.get(randomNumber);

			} else
				for (int y = 0; y < boardSize; y++) {
					if (board.getTileAt(1, y).getColor()
							.equals(PlayerColor.RED)) {
						if (board.getTileAt(0, y).getColor()
								.equals(PlayerColor.BLANK)) {
							return new Move(0, y);
						} else {
							Random randomNumberSource = new Random();
							int randomNumber = randomNumberSource
									.nextInt(legalMoves.size());
							return legalMoves.get(randomNumber);
						}
					} else if (board.getTileAt(boardSize - 2, y).getColor()
							.equals(PlayerColor.RED)) {
						if (board.getTileAt(boardSize - 1, y).getColor()
								.equals(PlayerColor.BLANK)) {
							return new Move(boardSize - 1, y);
						} else {
							Random randomNumberSource = new Random();
							int randomNumber = randomNumberSource
									.nextInt(legalMoves.size());
							return legalMoves.get(randomNumber);
						}
					}
				}
		}

		return null;

	}

	@Override
	public String getName() {
		return name;
	}

}
