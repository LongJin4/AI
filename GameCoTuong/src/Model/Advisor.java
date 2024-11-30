package Model;

public class Advisor extends ChessPiece {

	public Advisor(boolean color) {
		super(color);
		this.type = "Advisor";
	}

	@Override
	public void checkPattern(Move move,Tile[][] board) {
		// TODO Auto-generated method stub
		super.checkPattern(move, board);
		if (!move.isDiagonal()) {
			move.setValid(false);
		}
		if (Math.abs(move.getDx()) != 1) {
			move.setValid(false);
		}

		if (move.getFinalX() < 3 || move.getFinalX() > 5) {
			move.setValid(false);
		}

		if (this.color) {
			if (move.getFinalY() > 7) {
				move.setValid(false);
			}
		} else {

			if (move.getFinalY() < 2) {
				move.setValid(false);
			}
		}
	}

}
