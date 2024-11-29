package Model;



public class Elephant extends ChessPiece {
	
	public Elephant( boolean color) {
		super( color);
		this.type="Elephant";
	}

	

	@Override
	public void checkPattern(Move move) {
		super.checkPattern(move);

		if (!move.isDiagonal()) {
			move.setValid(false);
		}
		if (Math.abs(move.getDx()) != 2 && Math.abs(move.getDy())!= 2) {
			move.setValid(false);
		}

		// river crossing prevention
		if (this.color) {
			if (move.getFinalY() > 4) {
				move.setValid(false);
			}
		} else {
			if (move.getFinalY() < 5) {
				move.setValid(false);
			}
		}

	}
}
