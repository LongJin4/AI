package Model;

import java.util.ArrayList;
import java.util.List;

public class Soldier extends ChessPiece {
	private int value = 10;
	private List<Tile> listCanMove;

	public Soldier(boolean color) {
		super(color);
		this.type = "Soldier";
		listCanMove = new ArrayList<>();

	}

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		boolean isCrossed = false;
		if (this.color) {
			if (j + 1 < board[0].length)
				listCanMove.add(board[i][j + 1]);

			if (j > 5)
				isCrossed = true;

		} else {
			if (j - 1 > 0)
				listCanMove.add(board[i][j - 1]);
			if (j < 5)
				isCrossed = true;

		}
		if (isCrossed) {
			if (i < 8)
				listCanMove.add(board[i + 1][j]);
			if (i > 0)
				listCanMove.add(board[i - 1][j]);
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
