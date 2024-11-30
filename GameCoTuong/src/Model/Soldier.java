package Model;



public class Soldier extends ChessPiece {
	

	public Soldier( boolean color) {
		super( color);
		this.type="Soldier";
	}

	@Override
	public void checkPattern(Move move,Tile[][] board) {
		// TODO Auto-generated method stub
		super.checkPattern(move, board);
		boolean isCrossed;
		if (this.color) {
			if (move.getOriginY() < 5) {
				isCrossed = false;
			} else {
				isCrossed = true;
			}
		} else {
			if (move.getOriginY() > 5) {
				isCrossed = false;
			} else {
				isCrossed = true;
			}
		}
		if(!isCrossed) {
			if(Math.abs(move.getDy()) != 1 || !move.isVertical()) {
				move.setValid(false);
			}
		}
		else {
			if(Math.abs(move.getDy()) != 1 && Math.abs(move.getDx()) != 1 || !move.isHorizontal() && !move.isVertical()) {
				move.setValid(false);
			}
		}
	}
}
