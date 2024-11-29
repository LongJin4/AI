package Model;

public class Chariot extends ChessPiece {
	
	public Chariot( boolean color) {
		super( color);
		this.type="Chariot";
	}

	

	@Override
	public void checkPattern(Move move) {
		super.checkPattern(move);

		if (!move.isHorizontal() && !move.isVertical()) {
			move.setValid(false);
		}
	}

}
