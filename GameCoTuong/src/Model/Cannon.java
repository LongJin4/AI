package Model;

import java.util.Iterator;

public class Cannon extends ChessPiece {

	public Cannon(boolean color) {
		super(color);
		this.type = "Cannon";
	}

	@Override
	public void checkPattern(Move move, Tile[][] board) {
		// TODO Auto-generated method stub
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
