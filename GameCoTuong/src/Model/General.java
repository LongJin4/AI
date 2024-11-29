package Model;

public class General extends ChessPiece {

	

	public General(boolean color) {
		super(color);
		this.type="General";
	}

	
	@Override
	public String toString() {
		return "Vua " + color;
	}

	@Override

	public void checkPattern(Move move) {

		super.checkPattern(move);

		if (!move.isHorizontal() && !move.isVertical()) {
			move.setValid(false);
		}
		if (Math.abs(move.getDx()) > 1 || Math.abs(move.getDy()) > 1) {
			move.setValid(false);
		}

		// stays in generals quarters
		if (move.getFinalX() < 3 || move.getFinalX() > 5) {
			move.setValid(false);
		}

		if (this.color) {
			if (move.getFinalY() > 2) {
				move.setValid(false);
			}
		} else {
			if (move.getFinalY() < 7) {
				move.setValid(false);
			}
		}
	}
}
