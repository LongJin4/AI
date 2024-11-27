package Model;

public class Move {
	private ChessPiece piece;
	private ChessPiece capturedPiece;

	private int originX, originY;// tạo độ trc khi move
	private int finalX, finalY;// tạo độ sau khi move

	private int dx;
	private int dy;
	private boolean isHorizontal;// ngang
	private boolean isVertical;// thẳng
	private boolean isDiagonal;// chéo
	private boolean isValid;// hợp lệ

	public Move(int originX, int originY, int finalX, int finalY) {
		this.originX = originX;
		this.originY = originY;
		this.finalX = finalX;
		this.finalY = finalY;

		this.dx = finalX - originX;
		this.dy = finalY - originY;
		if (dx == 0 && dy != 0) {
			this.isVertical = true;
		}
		if (dy == 0 && dx != 0) {
			this.isHorizontal = true;
		}
		if (Math.abs(dx) == Math.abs(dy) && dx != 0) {
			this.isDiagonal = true;
		}

	}

	public int getOriginX() {
		return originX;
	}

	public int getOriginY() {
		return originY;
	}

	public int getFinalX() {
		return finalX;
	}

	public int getFinalY() {
		return finalY;
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public boolean isHorizontal() {
		return isHorizontal;
	}

	public boolean isVertical() {
		return isVertical;
	}

	public boolean isDiagonal() {
		return isDiagonal;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean v) {
		this.isValid = v;
	}

	public ChessPiece getPiece() {
		return piece;
	}

	public ChessPiece getCapturedPiece() {
		return capturedPiece;
	}

	public String toString() {
		return originX + ", " + originY + ", " + finalX + ", " + finalY;
	}
	
}
