package Model;

import java.util.ArrayList;
import java.util.List;

public class Advisor extends ChessPiece {
	private int value = 25;
	private List<Tile> listCanMove;

	public Advisor(boolean color) {
		super(color);
		this.type = "Advisor";
		listCanMove = new ArrayList<>();
	}

	

	@Override
	protected void UpDateListCanMove(int i, int j, Tile[][] board) {
		// TODO Auto-generated method stub
		listCanMove.clear();
		int up=j+1;
		int down=j-1;
		int left=i-1;
		int right=i+1;
		if (this.color) {
			if (down >= 0 &&left >= 3)
				listCanMove.add(board[left][down]);
			if (up <= 2 && left >= 3)
				listCanMove.add(board[left][up]);
			if (down >= 0 && right <= 5)
				listCanMove.add(board[right][down]);
			if (up <= 2 && right <= 5)
				listCanMove.add(board[right][up]);
		} else {
			if (down>= 7 && left >= 3)
				listCanMove.add(board[left][down]);
			if (up <= 9 && left >= 3)
				listCanMove.add(board[left][up]);
			if (down >= 7 && right<= 5)
				listCanMove.add(board[right][down]);
			if (up <= 9 && right <= 5)
				listCanMove.add(board[right][up]);
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
