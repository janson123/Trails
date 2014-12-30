package edu.indiana.cs.c212.players;

import java.util.List;
import java.util.Random;
import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class StupidDefenseAI extends AbstractPlayer {
	protected PlayerColor color;
	private String name;
	private int boardSize;
	private Move move;

	public StupidDefenseAI(PlayerColor c) {
		super(c);
		this.color = c;
		this.name = "StupidDefenseAI";
	}

	@Override
	public String getName() {
		return name;
	}

	// if StupidAI is red player it makes a random move first, and if you move
	// to a corner it blocks you.
	// But it no longer make any moves after that.
	// ???

	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		int boardSize = board.getSize();
		this.boardSize = boardSize;
		
		if (color.equals(PlayerColor.BLUE)) {
			if (!(board.getTileAt(0, 0).getColor() == color)
					&& !(board.getTileAt(0, 0).getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(0, 1).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(0, 1);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			} else if (!(board.getTileAt(boardSize - 1, 0).getColor() == color)
					&& !(board.getTileAt(boardSize - 1, 0).getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(boardSize - 1, 1).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(boardSize - 1, 1);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			} else if (!(board.getTileAt(boardSize - 1, boardSize - 1)
					.getColor() == color)
					&& !(board.getTileAt(boardSize - 1, boardSize - 1)
							.getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(boardSize - 1, boardSize - 2)
						.getColor() == PlayerColor.BLANK)) {
					this.move = new Move(boardSize - 1, boardSize - 2);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}

			} else if (!(board.getTileAt(0, boardSize - 1).getColor() == color)
					&& !(board.getTileAt(0, boardSize - 1).getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(0, boardSize - 2).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(0, boardSize - 2);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			} else {
				Random randomNumberSource = new Random();
				int randomNumber = randomNumberSource
						.nextInt(legalMoves.size());
				return legalMoves.get(randomNumber);
			}

		}
		
		// This looks kind of complex. Basically it checks the corners to see if
		// the blue player moved there, and it makes a block move if they did move to a corner.
		// It then has a check to make sure they don't try and move where they already blocked.
		// If no corners are moved to by a red player, then blue just makes random moves.
		if (color.equals(PlayerColor.RED)) {
			if (!(board.getTileAt(0, 0).getColor() == color)
					&& !(board.getTileAt(0, 0).getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(1, 0).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(1, 0);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			} else if (!(board.getTileAt(boardSize - 1, 0).getColor() == color)
					&& !(board.getTileAt(boardSize - 1, 0).getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(boardSize - 2, 0).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(boardSize - 2, 0);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			} else if (!(board.getTileAt(boardSize - 1, boardSize - 1)
					.getColor() == color)
					&& !(board.getTileAt(boardSize - 1, boardSize - 1)
							.getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(boardSize - 2, boardSize - 1).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(boardSize - 2, boardSize - 1);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}

			} else if (!(board.getTileAt(0, boardSize - 1).getColor() == color)
					&& !(board.getTileAt(0, boardSize - 1).getColor() == PlayerColor.BLANK)) {
				if ((board.getTileAt(1, boardSize - 1).getColor() == PlayerColor.BLANK)) {
					this.move = new Move(1, boardSize - 1);
					return move;
				} else {
					Random randomNumberSource = new Random();
					int randomNumber = randomNumberSource.nextInt(legalMoves
							.size());
					return legalMoves.get(randomNumber);
				}
			} else {
				Random randomNumberSource = new Random();
				int randomNumber = randomNumberSource
						.nextInt(legalMoves.size());
				return legalMoves.get(randomNumber);
			}

		}
		return null;

	}

}
