package Model;

public class Chariot extends ChessPiece {

	public Chariot(boolean color) {
		super(color);
		this.type = "Chariot";
	}

	@Override
	public void checkPattern(Move move, Tile[][] board) {
		move.setValid(false);

//		 kiểm tra xem có quân cờ nào trên đường đi không

		if (move.isHorizontal()) {
			move.setValid(true);
			for (int i = Math.min(move.getOriginX(), move.getFinalX()) + 1; i < Math.max(move.getOriginX(),
					move.getFinalX()); i++) {
				if (board[i][move.getOriginY()].getPiece() != null) {
					move.setValid(false);
					break;
				}
			}
		} else {
			if (move.isVertical()) {
				move.setValid(true);
				for (int i = Math.min(move.getOriginY(), move.getFinalY()) ; i < Math.max(move.getOriginY(),
						move.getFinalY()); i++) {
					if (board[move.getOriginX()][i].getPiece() != null&&i!=move.getOriginY()) {
						move.setValid(false);
						break;
					}
				}
			}
		}
	}

}
