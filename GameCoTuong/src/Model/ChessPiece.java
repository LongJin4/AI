package Model;

import java.io.File;

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
	 * @param move : nhận vào 1 nước đi để kiểm tra
	 */
	public void checkPattern(Move move) {
		move.setValid(true);
	}

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
}
