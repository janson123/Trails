package edu.indiana.cs.c212.board;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import edu.indiana.cs.c212.gameMechanics.Move;
import edu.indiana.cs.c212.gameMechanics.PlayerColor;


/*
@author janson
@author galexeev
*/

public class SimpleGameBoard extends AbstractGameBoard {
	private Tile[][] tileBoard;
	private Tile leftGoalBlue;
	private Tile rightGoalBlue;
	private Tile bottomGoalRed;
	private Tile topGoalRed;

	public SimpleGameBoard(int size) {
		this.size = size;
		tileBoard = new Tile[size][size];

		rightGoalBlue = new Tile(PlayerColor.BLUE, new Point(size, 0));
		leftGoalBlue = new Tile(PlayerColor.BLUE, new Point(-1, 0));
		topGoalRed = new Tile(PlayerColor.RED, new Point(0, -1));
		bottomGoalRed = new Tile(PlayerColor.RED, new Point(0, size));

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				tileBoard[x][y] = new Tile(PlayerColor.BLANK, new Point(x, y));
			}
		}

	}

	public SimpleGameBoard(SimpleGameBoard other) {
		size = other.size;
		tileBoard = new Tile[size][size];

		rightGoalBlue = new Tile(PlayerColor.BLUE, new Point(size, 0));
		leftGoalBlue = new Tile(PlayerColor.BLUE, new Point(-1, 0));
		topGoalRed = new Tile(PlayerColor.RED, new Point(0, -1));
		bottomGoalRed = new Tile(PlayerColor.RED, new Point(0, size));

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				tileBoard[x][y] = new Tile(other.getTileAt(x, y).getColor(), new Point(x, y));
			}
		}

	}

	@Override
	public Set<Tile> getNeighbors(Tile t) {
		Set<Tile> neighbors = new HashSet<>();

		if (t.equals(leftGoalBlue)) {
			for (int y = 0; y < size; y++) {
				neighbors.add(getTileAt(0, y));
			}
		} else if (t.equals(rightGoalBlue)) {
			for (int y = 0; y < size; y++) {
				neighbors.add(getTileAt(size - 1, y));
			}
		} else if (t.equals(topGoalRed)) {
			for (int x = 0; x < size; x++) {
				neighbors.add(getTileAt(x, 0));
			}
		} else if (t.equals(bottomGoalRed)) {
			for (int x = 0; x < size; x++) {
				neighbors.add(getTileAt(x, size - 1));
			}
		} else if (t.equals(getTileAt(0, 0))) { // topleft corner
			neighbors.add(getTileAt(1, 0));
			neighbors.add(getTileAt(0, 1));
			neighbors.add(getTileAt(-1, 0));
			neighbors.add(getTileAt(0, -1));
		}

		else if (t.equals(getTileAt(0, size - 1))) { // bottom left corner
			neighbors.add(getTileAt(1, size - 1));
			neighbors.add(getTileAt(1, size - 2));
			neighbors.add(getTileAt(0, size - 2));
			neighbors.add(getTileAt(-1, 0));
			neighbors.add(getTileAt(0, size));
		}

		else if (t.equals(getTileAt(size - 1, 0))) { // TopRight corner
			neighbors.add(getTileAt(0, -1));
			neighbors.add(getTileAt(size, 0));
			neighbors.add(getTileAt(size - 2, 0));
			neighbors.add(getTileAt(size - 2, 1));
			neighbors.add(getTileAt(size - 1, 1));

		} else if (t.equals(getTileAt(size - 1, size - 1))) { // BottomRight
																	// corner
			neighbors.add(getTileAt(0, size));
			neighbors.add(getTileAt(size, 0));
			neighbors.add(getTileAt(size - 1, size - 2));
			neighbors.add(getTileAt(size - 2, size - 1));
		}

		else {
			int newX = (int) t.getPoint().getX();
			int newY = (int) t.getPoint().getY();
			
			neighbors.add(getTileAt(newX - 1,newY));
			neighbors.add(getTileAt(newX + 1, newY));
			neighbors.add(getTileAt(newX -1, newY + 1));
			neighbors.add(getTileAt(newX, newY + 1));
			neighbors.add(getTileAt(newX + 1, newY - 1));
			neighbors.add(getTileAt(newX, newY - 1));
		}
		return neighbors;
	}

	@Override
	public Tile getTileAt(int x, int y) {
		if (x == -1) {
			return leftGoalBlue;
		} else if (x == size) {
			return rightGoalBlue;
		} else if (y == size) {
			return bottomGoalRed;
		} else if (y == -1) {
			return topGoalRed;
		} else if (x > size || y > size || x < -1 || y < -1) {
			return null;
		} else {
			return tileBoard[x][y];
		}
	}

	@Override
	public void makeMove(Move m, PlayerColor player) {
			getTileAt(m.getX(), m.getY()).setColor(player);

	}

}
