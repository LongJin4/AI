package Model;

import java.util.Objects;

public class Tile {
	int x;
	int y;
	int size;
	private ChessPiece piece;

	public Tile(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}

	public Tile(int x2, int y2) {
		// TODO Auto-generated constructor stub
		this.x = x2;
		this.y = y2;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public ChessPiece getPiece() {
		return this.piece;
	}

	public ChessPiece setPiece(ChessPiece piece) {
		return this.piece = piece;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
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
		return x == other.x && y == other.y;
	}

}
