package edu.indiana.cs.c212.players;

import java.awt.Point;
import java.util.List;
import java.util.Set;

import edu.indiana.cs.c212.board.Board;
import edu.indiana.cs.c212.board.Tile;
import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;

public class BasicTrailsPlayer extends AbstractPlayer {

	private PlayerColor color;
	private String name;
	private Boolean first; // is it the first move for the player
	private Tile current;
	private int boardSize;

	public BasicTrailsPlayer(PlayerColor c) {
		super(c);
		this.color = c;
		this.name = "Basic Trails Player";
		this.first = true;
	}

	@Override
	public Move getMove(Board board, List<Move> legalMoves) {
		this.boardSize = board.getSize();

		// if it is the first move you make.
		if (first == true) {
			// checks if you are a red or blue player
			if (this.color == PlayerColor.RED) {
				// this is now not the first move
				this.first = false;
				// this is the last move made by you
				current = new Tile(color, new Point(boardSize - 1, 0));
				// starts at the top right
				return new Move(boardSize - 1, 0);
			} else if (this.color == PlayerColor.BLUE) {
				if (board.getTileAt(0, boardSize - 1).getColor() == PlayerColor.BLANK) {
					first = false;
					current = new Tile(color, new Point(0, boardSize - 1));
					// starts in the bottom left
					return new Move(0, boardSize - 1);
				} else {
					first = false;
					current = new Tile(color, new Point(0, boardSize - 2));
					// moves above original starting point if blocked
					return new Move(0, boardSize - 2);
				}
			}
		} else {
			// executes this stuff if its not the first move
			Move move = getBest(board, current);
			// resets current to the "last tile" or currently analyzed tile.
			current = new Tile(color, new Point(move.getX(), move.getY()));
			// System.out.println(move);
			return move;
		}
		return null;
	}

	public Move getBest(Board board, Tile current) {
		// getTileAt
		int cx = (int) current.getPoint().getX();
		int cy = (int) current.getPoint().getY();

		if (color == PlayerColor.RED) {
			if (board.getTileAt(cx, cy + 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx, cy + 1);
			} else if (board.getTileAt(cx - 1, cy + 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx - 1, cy + 1);
			} else if (board.getTileAt(cx + 1, cy).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx + 1, cy);
			} else if (board.getTileAt(cx + 1, cy - 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx + 1, cy - 1);
			} else if (board.getTileAt(cx - 1, cy).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx - 1, cy);
			} 
			else {
				int y = 0;
				while (true) {
					int x = 1;
					while (true) {
						if (x == board.getSize()) {
							break;
						}
						if (board.getTileAt(x, y).getColor()
								.equals(PlayerColor.BLANK)) {
							return new Move(x, y);
						}
						x += 1;
					}
					y += 1;
				}
			}
		} else {

			if (board.getTileAt(cx + 1, cy).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx + 1, cy);
			} else if (board.getTileAt(cx, cy + 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx, cy + 1);
			} 
			else if (board.getTileAt(cx - 1, cy + 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx - 1, cy + 1);
			}
			else if (board.getTileAt(cx + 1, cy - 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx + 1, cy - 1);
			}
			else if (board.getTileAt(cx, cy - 1).getColor()
					.equals(PlayerColor.BLANK)) {
				return new Move(cx, cy - 1);
			}
			else {
				int x = 0;
				while (true) {
					int y = 1;
					while (true) {
						if (y == board.getSize()) {
							break;
						}
						if (board.getTileAt(x, y).getColor() == PlayerColor.BLANK) {
							return new Move(x, y);
						}
						y += 1;
					}
					x += 1;
				}
			}
		}
		// Score board function perhaps? That's an extension.

	}

	@Override
	public String getName() {
		return name;
	}

}
