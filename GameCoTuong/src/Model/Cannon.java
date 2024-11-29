package Model;

public class Cannon extends ChessPiece{

	public Cannon(boolean color) {
		super( color);
		this.type="Cannon";
	}

	

	 @Override

	    public void checkPattern(Move move) {
	        super.checkPattern(move);

	        if (!(move.isHorizontal() || move.isVertical())) {
	            move.setValid(false);
	        }
	    }

}
