package Model;

import java.io.File;
import java.util.List;

public abstract class ChessPiece {
	protected String type;
	private boolean captured;
	boolean color;// red=true black= false
	protected File image;

	public ChessPiece(boolean color) {
		this.color = color;
		this.captured = false;
		this.type = this.getClass().getSimpleName();
		this.image = new File(this.getImagePath());

	}

	/**
	 * Hàm kiểm tra logic nước đi
	 * 
	 * @param move  : nhận vào 1 nước đi để kiểm tra
	 * @param board
	 */
	public void checkPattern(Move move, Tile[][] board) {
		if (this.getListCanmove().contains(board[move.getFinalX()][move.getFinalY()])) {
			this.setValue( move.getFinalX(), move.getFinalY());
			move.setValid(true);
		} else {
			move.setValid(false);
		}
	}

	protected abstract void setValue(int finalX, int finalY);

	protected abstract List<Tile> getListCanmove();

	public abstract int getValue();

	public void Capture() {
		this.captured = true;
	}

	public File getImage() {
		return this.image;
	}

	/**
	 * Returns the image path for the chess piece.
	 * 
	 * @return The file path for the piece image.
	 */
	private String getImagePath() {
		String fileName = "src/chess_pieces_Image/";
		fileName += color ? "r" : "b"; // r for red, b for black

		// Map type to file name prefix
		switch (type) {
		case "Soldier":
			fileName += "P";
			break;
		case "General":
			fileName += "K";
			break;
		case "Cannon":
			fileName += "C";
			break;
		case "Horse":
			fileName += "N";
			break;
		case "Elephant":
			fileName += "B";
			break;
		case "Advisor":
			fileName += "A";
			break;
		case "Chariot":
			fileName += "R";
			break;
		default:
			throw new IllegalArgumentException("Unknown piece type: " + type);
		}

		fileName += ".png";
		return fileName;
	}

	public boolean getColor() {
		return this.color;
	}

	protected int heuristic() {
		int res = 0;
		for (Tile tile : this.getListCanmove()) {
			if (tile.getPiece() != null)
				res += (tile.getPiece().getValue()) / 2;
		}
		return this.getValue() + res;
	}

	protected abstract void UpDateListCanMove(int i, int j, Tile[][] board);

}
