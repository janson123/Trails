package edu.indiana.cs.c212.board;

import java.awt.Point;

import edu.indiana.cs.c212.gameMechanics.PlayerColor;

/*
@author janson
@author galexeev

*/


public class Tile {
	private PlayerColor color;
	private Point point;

	public Tile(PlayerColor color, Point point) {
		super();
		this.color = color;
		this.point = point;

	}

	public Tile(Tile tile) {
		super();
		point = new Point(tile.point);
		color = tile.color;

	}

	public PlayerColor getColor() {
		return color;
	}

	public void setColor(PlayerColor color) {
		this.color = color;
	}

	public Point getPoint() {
		return point;
	}

	@Override
	public String toString() {
		return point + " " + color;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		// result = prime * result + ((tile == null) ? 0 : tile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (color != other.color)
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
			return false;
		return true;
	}

}