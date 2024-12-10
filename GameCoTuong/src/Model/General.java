package Model;

import java.util.ArrayList;
import java.util.List;

public class General extends ChessPiece {

	private int value = 10000;
	private List<Tile> listCanMove;

	public General(boolean color) {
		super(color);
		this.type = "General";
		listCanMove = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Vua " + color;
	}

	@Override

	public void checkPattern(Move move, Tile[][] board) {

		super.checkPattern(move, board);
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

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		if (i + 1 <= 5)
			listCanMove.add(board[i + 1][j]);
		if (i - 1 >= 3)
			listCanMove.add(board[i - 1][j]);
		
		if (this.color) {
			
			if (j - 1 >= 0)
				listCanMove.add(board[i][j - 1]);
			if (j + 1 <= 2)
				listCanMove.add(board[i][j + 1]);
		} else {
			
			if (j - 1 >= 7)
				listCanMove.add(board[i][j - 1]);
			if (j + 1 <= 9)
				listCanMove.add(board[i][j + 1]);
		}
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	protected List<Tile> getListCanmove() {
		// TODO Auto-generated method stub
		return listCanMove;
	}
}
